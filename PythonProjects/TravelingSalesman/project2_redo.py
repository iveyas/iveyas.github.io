import matplotlib.pyplot as plt
import numpy as np
import random
import copy
import math
import operator

plt.ion()
plt.figure(figsize=(10, 5))


def plotTSP(generation, path, points, path_distance, save, num_iters=1):
    """
	generation: The generation number to display
	path: List of lists with the different orders in which the nodes are visited
	points: coordinates for the different nodes
	path_distance: the distance to display in the figure
	save: True if saving to final_route.png, False otherwise
	num_iters: number of paths that are in the path list

	SOURCE: https://gist.github.com/payoung/6087046

	"""
    ### MOD: Brian Bennett

    plt.suptitle("Tennessee Traveling Salesman - Generation " + str(generation) + \
                 "\nPath Length: " + str(path_distance))
    ### END MOD

    # Unpack the primary TSP path and transform it into a list of ordered
    # coordinates

    x = []
    y = []
    for i in path:
        x.append(points[i][0])
        y.append(points[i][1])

    plt.plot(x, y, 'ko')

    # Set a scale for the arrow heads (there should be a reasonable default for this, WTF?)
    a_scale = 2.5
    # Draw the older paths, if provided
    if num_iters > 1:

        for i in range(1, num_iters):

            # Transform the old paths into a list of coordinates
            xi = [];
            yi = [];
            for j in paths[i]:
                xi.append(points[j][0])
                yi.append(points[j][1])

            plt.arrow(xi[-1], yi[-1], (xi[0] - xi[-1]), (yi[0] - yi[-1]),
                      head_width=a_scale, color='r',
                      length_includes_head=True, ls='dashed',
                      width=0.001 / float(num_iters))
            for i in range(0, len(x) - 1):
                plt.arrow(xi[i], yi[i], (xi[i + 1] - xi[i]), (yi[i + 1] - yi[i]),
                          head_width=a_scale, color='r', length_includes_head=True,
                          ls='dashed', width=0.001 / float(num_iters))

    # Draw the primary path for the TSP problem
    plt.arrow(x[-1], y[-1], (x[0] - x[-1]), (y[0] - y[-1]), head_width=a_scale,
              color='b', length_includes_head=True)
    for i in range(0, len(x) - 1):
        plt.arrow(x[i], y[i], (x[i + 1] - x[i]), (y[i + 1] - y[i]), head_width=a_scale,
                  color='b', length_includes_head=True)

    if save:
        plt.savefig("final_route.png")

    plt.pause(1)


class GeneticSearch:
    """
		Class: GeneticSearch
	"""

    def __init__(self, origin, generations, points, cities, population_size, mutation_rate):
        self.population = None
        self.points = points
        self.cities = cities
        self.chromosome_size = len(self.points)
        self.generations = generations
        self.population_size = population_size
        self.mutation_rate = mutation_rate
        self.origin = origin
        self.origin_index = self.points.index(self.origin)
        self.values = []

    def print_population(self, generation, chromosomes):
        index = 0
        print("===== GENERATION %d" % generation)
        for chromosome in self.population:
            print("Index %5d , Fitness %0.4f : %s" % (index, chromosome[1], ''.join(str(chromosome[0]))))
            index = index + 1
            if index > chromosomes:
                break

    def initialize_population(self):

        self.population = []

        # TODO: This code generates a random initial population.
        #  INITIAL STRATEGY WITH CROSSOVER AND FIRST CHOICES FROM THE OTHER PARENT TO PREVENT DUPLICATES
        for i in range(self.population_size):

            individual = [x for x in range(self.chromosome_size)]
            random.shuffle(individual)

            # Move the origin_index to the front of the path
            individual.remove(self.origin_index)
            individual = [self.origin_index] + individual

            fitness = self.fitnessfcn(individual)

            # Prevent duplicate individuals in the initial population
            while [individual, fitness] in self.population:
                individual = [x for x in range(self.chromosome_size)]
                #random.shuffle(individual)

                individual.remove(self.origin_index)
                individual = [self.origin_index] + individual

                fitness = self.fitnessfcn(individual)

            # POPULATION NODES are in the form [chromosome, fitness]
            self.population.append([individual, fitness])

        # Sort the population in descending order
        # -- "Maximize the objective function"
        self.population.sort(key=operator.itemgetter(1), reverse=True)

    def straight_line_distance(self, p1, p2):
        '''
			Return the Euclidian Distance between p1 and p2
		'''
        sld = math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)
        return sld

    def route_distance(self, individual):
        '''
			Determine the distance for the entire route
		'''
        distance = 0
        value = 0

        tour = individual + [self.origin_index]

        index = 0
        p1 = p2 = None
        while p2 != self.origin:
            p1 = self.points[tour[index]]
            p2 = self.points[tour[index + 1]]
            distance += self.straight_line_distance(p1, p2)
            index += 1

        return distance

    def fitnessfcn(self, individual):
        '''
			Return the negative route distance so it can be maximized.
		'''
        return -self.route_distance(individual)

    def select_parents(self):
        '''
			Selects two parents from the population and returns them as a list
		'''
        # TODO: Consider a selection strategy
        #PARENT SELECTION WITH 20% TOP FIRST CHOICE THEN 75% IF THE PARENTS ARE TOO ALIKE
        parent1 = self.population[random.randint(0, 2)][0]
        parent2 = self.population[random.randint(0, 3)][0]

        while parent1 == parent2:
            parent2 = self.population[random.randint(0, 15)][0]

        return parent1, parent2

    def reproduce(self, parent1, parent2):
        '''
			Reproduce using parent1 and parent2 and a crossover
			 strategy.
		'''
        crossover = random.randrange(0,self.chromosome_size)
        # TODO: Implement a reproduction (e.g., crossover) strategy.
        parent1Top = {}
        parent1Top= parent1[:crossover]
        child1 = parent1Top + [i for i in parent2 if i not in parent1Top]

        crossover = random.randrange(0,self.chromosome_size)
        parent2Top = {}
        parent2Top = parent1[crossover:]
        child2 =  [j for j in parent1 if j not in parent2Top] + parent2Top

        return child1, child2

    def mutate(self, child):
        '''
            Mutation Strategy
        '''

        # TODO: Implement a mutation strategy

        pleaseMutate = True
        starterChild = list(child)
        geneFinderTop = 1
        geneFinderBottom = self.chromosome_size - 1
        geneFinderMiddle = math.floor(self.chromosome_size / 2)
        geneFinderMiddle2 = math.floor(self.chromosome_size / 2) + 1

        #GENETIC MUTATION
        x = 0
        for x in range(0,2):
            mutatePoint1 = random.randint(1,self.chromosome_size-1)
            mutatePoint2 = random.randint(1,self.chromosome_size-1)
            tempVal1 = child[mutatePoint1]
            tempVal2 = child[mutatePoint2]
            child[mutatePoint1] = tempVal2
            child[mutatePoint2] = tempVal1
            x+=1
        #HOT ANNEALING MUTATION
        x = 0
        for x in range(0,5):
            while pleaseMutate == True and not geneFinderTop == geneFinderBottom:  # and abs(self.fitnessfcn()) > 2300:
                tempVal1 = starterChild[geneFinderBottom]
                tempVal2 = starterChild[geneFinderTop]
                starterChild[geneFinderBottom] = tempVal2
                starterChild[geneFinderTop] = tempVal1
                if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
                    child = list(starterChild)
                    geneFinderBottom = self.chromosome_size - 1
                    geneFinderTop = 1
                    # pleaseMutate = False
                    return child
                else:
                    x = 1
                    y = 2
                    starterChild = list(child)
                    for x in range(1, self.chromosome_size - 1):
                        for y in range(2, self.chromosome_size - 1):
                            mutatePoint1 = x
                            mutatePoint2 = y
                            tempVal1 = starterChild[mutatePoint1]
                            tempVal2 = starterChild[mutatePoint2]
                            starterChild[mutatePoint1] = tempVal2
                            starterChild[mutatePoint2] = tempVal1

                            if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
                                child = list(starterChild)
                                return child
                            starterChild = list(child)
                            y += 1
                        y = 0
                        x += 1
                    # geneFinderBottom = geneFinderBottom - 1
                    # geneFinderTop = geneFinderTop + 1
            geneFinderBottom = self.chromosome_size - 1
            geneFinderTop = 1
            x+=1

        # #WARM ANNEALING MUTATION
        #
        #
        # #GOES TO THE TOP VALUES AND MOVES INWARD TO FIND TWO CHROMES TO CHANGE
        # x = 0
        # for x in range(0, 4):
        #     geneFinderTop = 1
        #     pleaseMutate = True
        #     while pleaseMutate == True and not geneFinderTop == geneFinderMiddle:
        #         tempVal1 = starterChild[geneFinderMiddle]
        #         tempVal2 = starterChild[geneFinderTop]
        #         starterChild[geneFinderMiddle] = tempVal2
        #         starterChild[geneFinderTop] = tempVal1
        #         if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
        #             child = list(starterChild)
        #             geneFinderTop = 1
        #             geneFinderMiddle = math.floor(self.chromosome_size / 2)
        #             # pleaseMutate = False
        #             return child
        #         else:
        #             geneFinderMiddle = geneFinderMiddle - 1
        #             geneFinderTop = geneFinderTop + 1
        #     geneFinderTop = 1
        #     geneFinderMiddle = math.floor(self.chromosome_size / 2)
        #     x += 1
        #
        # #FINDS THE BOTTOM TWO FROM IN TO OUT TO CHANGE
        # x = 0
        # for x in range(0, 3):
        #     geneFinderBottom = self.chromosome_size - 1
        #     pleaseMutate = True
        #     while pleaseMutate == True and not geneFinderMiddle2 > (self.chromosome_size - 1):
        #         tempVal3 = starterChild[geneFinderMiddle2]
        #         tempVal4 = starterChild[geneFinderBottom]
        #         starterChild[geneFinderMiddle2] = tempVal4
        #         starterChild[geneFinderBottom] = tempVal3
        #         if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
        #             child = list(starterChild)
        #             geneFinderBottom = self.chromosome_size - 1
        #             geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #             # pleaseMutate= False
        #             return child
        #         else:
        #             geneFinderMiddle2 = geneFinderMiddle2 + 1
        #             geneFinderBottom = geneFinderBottom - 1
        #     geneFinderBottom = self.chromosome_size - 1
        #     geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #     x += 1
        # x = 1
        # for x in range(0, 3):
        #     midLow = math.floor(self.chromosome_size/4)
        #     geneFinderMiddle2 = self.chromosome_size - 1
        #     pleaseMutate = True
        #     while pleaseMutate == True and geneFinderMiddle2 > midLow:
        #         tempVal3 = starterChild[geneFinderMiddle2]
        #         tempVal4 = starterChild[midLow]
        #         starterChild[geneFinderMiddle2] = tempVal4
        #         starterChild[midLow] = tempVal3
        #         if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
        #             child = list(starterChild)
        #             midLow = math.floor(self.chromosome_size/4)
        #             geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #             # pleaseMutate= False
        #             return child
        #         else:
        #             geneFinderMiddle2 = geneFinderMiddle2 - 1
        #             midLow = midLow + 1
        #     midLow = math.floor(self.chromosome_size/4)
        #     geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #     x += 1
        #
        # x = 0
        # for x in range(0, 2):
        #     midLow = math.floor(self.chromosome_size/4)
        #     midHigh = math.floor(midLow * 3)
        #     geneFinderMiddle2 = self.chromosome_size - 1
        #     pleaseMutate = True
        #     while pleaseMutate == True and geneFinderMiddle2 < midHigh:
        #         tempVal3 = starterChild[geneFinderMiddle2]
        #         tempVal4 = starterChild[midHigh]
        #         starterChild[geneFinderMiddle2] = tempVal4
        #         starterChild[midHigh] = tempVal3
        #         if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
        #             child = list(starterChild)
        #             midHigh = math.floor(midLow*3)
        #             geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #             # pleaseMutate= False
        #             return child
        #         else:
        #             geneFinderMiddle2 = geneFinderMiddle2 + 1
        #             midhigh = midHigh - 1
        #     midLow = math.floor(geneFinderMiddle / 2)
        #     geneFinderMiddle2 = math.floor(self.chromosome_size / 2)
        #     x += 1
        # x = 0
        #
        # #COOLING ANNEALING MUTATION
        # x = 0
        # for x in range(0,2):
        #     geneFinderTop = 1
        #     geneFinderBottom = self.chromosome_size - 1
        #     geneFinderMiddle = math.floor(self.chromosome_size / 2)
        #     geneFinderMiddle2 = math.floor(self.chromosome_size / 2) + 1
        #     pleaseMutate = True
        #     while pleaseMutate == True and not geneFinderTop < math.floor(self.chromosome_size/2) + 1:
        #         tempVal1 = starterChild[geneFinderTop + 1]
        #         tempVal2 = starterChild[geneFinderTop]
        #         starterChild[geneFinderTop + 1] = tempVal2
        #         starterChild[geneFinderTop] = tempVal1
        #         if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
        #             child = list(starterChild)
        #             geneFinderTop = 1
        #             #pleaseMutate = False
        #             return child
        #         else:
        #             geneFinderMiddle = geneFinderMiddle - 1
        #             geneFinderTop = geneFinderTop + 1
        #     geneFinderTop = 1
        #     x += 1
        if(self.fitnessfcn(child )<5000):
            x = 1
            y = 2
            starterChild = list(child)
            for x in range(1,self.chromosome_size -1):
                for y in range(2,self.chromosome_size -1):
                    mutatePoint1 = x
                    mutatePoint2 = y
                    tempVal1 = starterChild[mutatePoint1]
                    tempVal2 = starterChild[mutatePoint2]
                    starterChild[mutatePoint1] = tempVal2
                    starterChild[mutatePoint2] = tempVal1
                    if abs(self.fitnessfcn(starterChild)) < abs(self.fitnessfcn(child)):
                        child = list(starterChild)
                        return child
                    starterChild = list(child)
                    y += 1
                y=0
                x += 1

        #SECOND GENETIC MUTATION
        # x = 0
        # for x in range(0,3):
        #     mutatePoint1 = random.randint(1,self.chromosome_size-1)
        #     mutatePoint2 = random.randint(1,self.chromosome_size-1)
        #     tempVal1 = child[mutatePoint1]
        #     tempVal2 = child[mutatePoint2]
        #     child[mutatePoint1] = tempVal2
        #     child[mutatePoint2] = tempVal1
        #     x+=1
        return child

    def print_result(self):
        '''
			Displays the resulting route in the console.
		'''
        individual = self.population[0][0]
        fitness = self.population[0][1]

        print(" Final Route in %d Generations" % self.generations)
        print(" Final Distance : %5.3f\n" % -fitness)

        counter = 1

        for index in individual:
            print("%2d. %s" % (counter, self.cities[index]))
            counter += 1

        print("%2d. %s" % (counter, self.cities[self.origin_index]))

    def run(self):
        '''
			Run the genetic algorithm. Note that this method initializes the
			 first population.
		'''
        generations = 0

        # TODO: Update Initialization
        self.initialize_population()

        last_fitness = 0
        fitness_counter = 0

        while generations <= self.generations:
            new_population = []
            parent1 = []
            parent2 = []

            while len(new_population) < self.population_size:

                # TODO: Update selection
                parent1, parent2 = self.select_parents()
                # TODO: Update reproduction
                child1, child2 = self.reproduce(parent1, parent2)

                # TODO: Update Mutation
                # Generate a random number, and only mutate if the number
                #  is below the mutation rate.
                if (random.random() < self.mutation_rate):
                    child1 = self.mutate(child1)
                if (random.random() < self.mutation_rate):
                    child2 = self.mutate(child2)

                fitness1 = self.fitnessfcn(child1)
                fitness2 = self.fitnessfcn(child2)

                new_population.append([child1, fitness1])
                new_population.append([child2, fitness2])

            generations = generations + 1

            # Sort the new population in descending order
            new_population.sort(key=operator.itemgetter(1), reverse=True)

            self.population = new_population

            # TODO: Change display rate as needed. Set by 1000 as default.
            if generations % 100 == 0 or generations >= self.generations:
                print("Generation: %d" % generations, "Fitness: %f" % self.population[0][1])
                if generations == self.generations:
                    plotTSP(generations, self.population[0][0], self.points, self.population[0][1], True)
                else:
                    plt.cla()
                    plotTSP(generations, self.population[0][0], self.points, self.population[0][1], False)

            self.values.append(self.population[0][1])

        self.print_result()


if __name__ == '__main__':

    city_coordinates = "coordinates.txt"
    city_names = "cities.txt"
    start_city = "Johnson City, TN"
    locations = list(np.loadtxt(city_coordinates))
    cities = [line.rstrip('\n') for line in open(city_names)]
    points = []
    paths = []
    start_city_index = [i for i in range(len(cities)) if cities[i] == start_city][0]

    loc_x = [x for x, y in locations]
    loc_y = [y for x, y in locations]
    loc_c = ["black" for _ in range(len(locations))]

    for i in range(0, len(loc_x)):
        points.append((loc_x[i], loc_y[i]))

    # origin, generations, points, population_size, mutation_rate
    origin = (locations[start_city_index][0], locations[start_city_index][1])

    # TODO: Adjust parameters as needed
    # Parameters: 1. origin location,
    #             2. number of generations,
    #             3. locations as a list of tuples,
    #             4. list of city names,
    #             5. number of individuals in each generation,
    #             6. mutation rate
    gs = GeneticSearch(origin, 50000, points, cities, 20, 0.60)
    gs.run()

    x = input("Press Enter to Exit...")
    plt.close()