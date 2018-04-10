import csv

import nltk
from nltk import WordNetLemmatizer
from nltk.corpus import stopwords, PlaintextCorpusReader
from nltk.tokenize import RegexpTokenizer
from nltk.stem.snowball import SnowballStemmer
from gensim import corpora, models
import gensim
from sklearn.cluster import KMeans
from sklearn.feature_extraction.text import CountVectorizer, TfidfVectorizer
import pandas as pd
import re
import numpy as np
import matplotlib.pyplot as plt

def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        return False

tokenizer = RegexpTokenizer(r'\w+')
valid = re.compile(r"^[^0-9][a-zA-Z0-9_]+$") #this is the regex to take out all the numbers

# create English stop words list
en_stop = stopwords.words('english')

# Create p_stemmer of class Snowball
p_stemmer = nltk.SnowballStemmer('english')
p_lemmatizer = WordNetLemmatizer()

corpus_root = 'speeches'
libraryOfTerms = {}
wordlists = PlaintextCorpusReader(corpus_root, '.*') #reads the words in from the text files
docs = []
doc_set = []


# compile sample documents into a list
for x in wordlists.fileids():
    doc_set.append(" ".join(wordlists.words(x)))
print(wordlists.fileids())
# list for tokenized documents in loop
texts = []

# loop through document list
for i in doc_set:
    # clean and tokenize document string
    raw = i.lower()
    tokens = tokenizer.tokenize(raw)

    # remove stop words from tokens
    stopped_tokens = [i for i in tokens if not i in en_stop]

    # stem tokens
    stemmed_tokens = [p_stemmer.stem(i) for i in stopped_tokens if is_number(i) == False]

    #add tokens to the list that are lemmetized
    texts.append(stemmed_tokens)

    docs.append(str(stemmed_tokens))

#creates a bag of words to use in the frequency distrobution plot
temp = []
for x in texts:
    temp.extend(x)
freq = nltk.FreqDist(temp)
#freq.plot(25, cumulative=False)


# turn our tokenized documents into a id <-> term dictionary
dictionary = corpora.Dictionary(texts)

# convert tokenized documents into a document-term matrix
corpus = [dictionary.doc2bow(text) for text in texts]

# generate LDA model
ldamodel = models.LdaModel(corpus = corpus, num_topics=25, id2word=dictionary)
lsimodel = models.LsiModel(corpus=corpus, num_topics=25, id2word=dictionary)
ldamodel.print_topics(num_topics=25, num_words=1)

for idx in range(25):
    # Print the first 10 most representative topics
    print("Topic #%s:" % idx, ldamodel.print_topic(idx, 1))

print("=" * 25)

print("LSI Model:")

for idx in range(25):
    # Print the first 10 most representative topics
    print("Topic #%s:" % idx, lsimodel.print_topic(idx, 1))

print("=" * 20)


doc_topics = ldamodel.get_topics().tolist()

corpusList = pd.DataFrame(doc_topics)
corpusList.to_csv("corpus.csv")
#print(ldamodel.print_topics(num_topics=4, num_words=4))

#print(dictionary.token2id)

#creates the document term matrix with lemmatized words with no stop words or numbers
#print("Document-Term Matrix...")
vec = CountVectorizer()
X = vec.fit_transform(docs)
df = pd.DataFrame(X.toarray(), columns=vec.get_feature_names())
#print(df) # Show the full data frame
df.to_csv('DocumentTeamMatrix.csv', ",", '#')

#for n_clust in range(2, 50):
#kmeans = KMeans(init='k-means++', n_clusters=5)
#fit = kmeans.fit(df)
#print(n_clust, fit.inertia_)


kmeans = KMeans(init='k-means++', n_clusters=10)
fit = kmeans.fit(df)

indices = {i: np.where(fit.labels_ == i)[0] for i in range(fit.n_clusters)}
labels = wordlists.fileids()

for index in range(fit.n_clusters):
    values = indices[int(index)]
    label = [labels[val] for val in values]
    print(50*"-")
    print("Cluster %s Information" % index)
    for val in set(label):
        print(str(val))
#changed variable for the input documents
cluster1Words = [
'1789-Washington.txt',
'1793-Washington.txt',
'1797-Adams.txt',
'1801-Jefferson.txt',
'1805-Jefferson.txt',
'1809-Madison.txt',
'1813-Madison.txt',
'1829-Jackson.txt',
'1833-Jackson.txt',
'1849-Taylor.txt',
'1865-Lincoln.txt',
'1869-Grant.txt',
'1873-Grant.txt',
'1885-Cleveland.txt',
'1893-Cleveland.txt',
'1901-McKinley.txt',
'1905-Roosevelt.txt',
'1913-Wilson.txt',
'1917-Wilson.txt',
'1921-Harding.txt',
'1933-Roosevelt.txt',
'1937-Roosevelt.txt',
'1941-Roosevelt.txt',
'1945-Roosevelt.txt',
'1949-Truman.txt',
'1953-Eisenhower.txt',
'1957-Eisenhower.txt',
'1961-Kennedy.txt',
'1965-Johnson.txt',
'1969-Nixon.txt',
'1973-Nixon.txt',
'1977-Carter.txt',
'1981-Reagan.txt',
'1985-Reagan.txt',
'1989-Bush.txt',
'1993-Clinton.txt',
'1997-Clinton.txt',
'2001-Bush.txt',
'2005-Bush.txt',
'2009-Obama.txt',
'2013-Obama.txt',
'2017-Trump.txt']

cluster2Words = [
'1817-Monroe.txt',
'1821-Monroe.txt',
'1825-Adams.txt',
'1837-VanBuren.txt',
'1841-Harrison.txt',
'1845-Polk.txt',
'1853-Pierce.txt',
'1857-Buchanan.txt',
'1861-Lincoln.txt',
'1877-Hayes.txt',
'1881-Garfield.txt',
'1889-Harrison.txt',
'1897-McKinley.txt',
'1909-Taft.txt',
'1925-Coolidge.txt',
'1929-Hoover.txt']

cluster1700= ['1789-Washington.txt',
'1793-Washington.txt',
'1797-Adams.txt']

cluster1800= ['1801-Jefferson.txt',
'1805-Jefferson.txt',
'1809-Madison.txt',
'1813-Madison.txt',
'1829-Jackson.txt',
'1833-Jackson.txt',
'1849-Taylor.txt',
'1865-Lincoln.txt',
'1869-Grant.txt',
'1873-Grant.txt',
'1885-Cleveland.txt',
'1893-Cleveland.txt',
'1817-Monroe.txt',
'1821-Monroe.txt',
'1825-Adams.txt',
'1837-VanBuren.txt',
'1841-Harrison.txt',
'1845-Polk.txt',
'1853-Pierce.txt',
'1857-Buchanan.txt',
'1861-Lincoln.txt',
'1877-Hayes.txt',
'1881-Garfield.txt',
'1889-Harrison.txt',
'1897-McKinley.txt'
]

cluster1900= ['1901-McKinley.txt',
'1905-Roosevelt.txt',
'1913-Wilson.txt',
'1917-Wilson.txt',
'1921-Harding.txt',
'1933-Roosevelt.txt',
'1937-Roosevelt.txt',
'1941-Roosevelt.txt',
'1945-Roosevelt.txt',
'1949-Truman.txt',
'1953-Eisenhower.txt',
'1957-Eisenhower.txt',
'1961-Kennedy.txt',
'1965-Johnson.txt',
'1969-Nixon.txt',
'1973-Nixon.txt',
'1977-Carter.txt',
'1981-Reagan.txt',
'1985-Reagan.txt',
'1989-Bush.txt',
'1993-Clinton.txt',
'1997-Clinton.txt',
'1909-Taft.txt',
'1925-Coolidge.txt',
'1929-Hoover.txt']

cluster2000= ['2001-Bush.txt',
'2005-Bush.txt',
'2009-Obama.txt',
'2013-Obama.txt',
'2017-Trump.txt']

#input the cluster that you want to see the data on and it will show you the frequency and the LSI
def changeCluster(inputCluster):
    for x in inputCluster:
        doc_set.append(" ".join(wordlists.words(x)))

    # list for tokenized documents in loop
    texts = []

    # loop through document list
    for i in doc_set:
        # clean and tokenize document string
        raw = i.lower()
        tokens = tokenizer.tokenize(raw)

        # remove stop words from tokens
        stopped_tokens = [i for i in tokens if not i in en_stop]

        # stem tokens
        stemmed_tokens = [p_stemmer.stem(i) for i in stopped_tokens if is_number(i) == False]

        #add tokens to the list that are lemmetized
        texts.append(stemmed_tokens)

        docs.append(str(stemmed_tokens))

    #creates a bag of words to use in the frequency distrobution plot
    temp = []
    for x in texts:
        temp.extend(x)
    freq = nltk.FreqDist(temp)
    freq.plot(25, cumulative=False)


    # turn our tokenized documents into a id <-> term dictionary
    dictionary = corpora.Dictionary(texts)

    # convert tokenized documents into a document-term matrix
    corpus = [dictionary.doc2bow(text) for text in texts]

    # generate LDA model
    ldamodel = models.LdaModel(corpus = corpus, num_topics=25, id2word=dictionary)
    lsimodel = models.LsiModel(corpus=corpus, num_topics=25, id2word=dictionary)
    ldamodel.print_topics(num_topics=25, num_words=1)

    for idx in range(25):
        # Print the first 10 most representative topics
        print("Topic #%s:" % idx, ldamodel.print_topic(idx, 1))

    print("=" * 25)

    print("LSI Model:")

    for idx in range(25):
        # Print the first 10 most representative topics
        print("Topic #%s:" % idx, lsimodel.print_topic(idx, 1))

    print("=" * 20)


    doc_topics = ldamodel.get_topics().tolist()

    corpusList = pd.DataFrame(doc_topics)
    corpusList.to_csv("corpus.csv")
    #print(ldamodel.print_topics(num_topics=4, num_words=4))

    #print(dictionary.token2id)

    #creates the document term matrix with lemmatized words with no stop words or numbers
    print("Document-Term Matrix...")
    vec = CountVectorizer()
    X = vec.fit_transform(docs)
    df = pd.DataFrame(X.toarray(), columns=vec.get_feature_names())
    print(df) # Show the full data frame

#uses the change cluster method so that we can see the differences between different groups.
changeCluster(cluster1Words)

changeCluster(cluster2Words)

changeCluster(cluster1700)

changeCluster(cluster1800)

changeCluster(cluster1900)

changeCluster(cluster2000)
