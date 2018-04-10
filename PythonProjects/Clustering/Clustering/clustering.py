import numpy as np
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
from sklearn.datasets import load_digits
from sklearn.cluster import AgglomerativeClustering
from lab7_dendrogram import plot_dendrogram


digits = load_digits()
data = digits.data #list of lists one 64 element list per image with intensity for each bit in the 8x8 images
#labels = digits.target_names
#print(data.shape)
#print(data[0])
#print(digits.target[0]) #list that contains the number each image represents
#print(labels[0])
#plt.gray()
#plt.figure(0,figsize=(3,3))
#plt.matshow(digits.images[0]) #list of bitmap images of each written digit
#plt.show()

# for n_clust in range(2, 10):
#kmeans = KMeans(init='k-means++', n_clusters=10)
#fit = kmeans.fit(data)
#     print(n_clust, fit.inertia_)

hac = AgglomerativeClustering(n_clusters=10)
fit = hac.fit(data[:50])
plot_dendrogram(fit)
plt.show()

indices = {i: np.where(fit.labels_ == i)[0] for i in range(fit.n_clusters)}
labels = digits.target

for index in range(fit.n_clusters):
    values = indices[int(index)]
    label = [labels[val] for val in values]
    print(50*"-")
    print("Cluster %s Information" % index)
    for val in set(label):
        print("Value:",str(val),"Count:",str(label.count(val)))
    print(50*"-")
