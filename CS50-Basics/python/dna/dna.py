import sys
import csv
import collections


def main():

    x = len(sys.argv)

    if x != 3:
        print(f"Usage: {sys.argv[0]} data.csv sequence.txt")
        return 1

    dataFile = open(sys.argv[1], "r")
    dataCSV = csv.reader(dataFile)
    sequenceFile = open(sys.argv[2], "r")

    data = []*9
    sequence = ""

    for line in dataCSV:
        data.append(line)

    for line in sequenceFile:
        sequence += line

    sequence1 = data[0]
    sequence1Length = len(sequence1)
    sequenceLength = len(sequence)
    sequence1Length -= 1

    answer = [0] * sequence1Length
    for x in range(sequence1Length+1):
        string = sequence1[x]
        # needs to match_exists no of times a string is repeated in sequence
        answer[(x-1)] = getSTR(sequence, string)
            
    i = 1
    match_exists = False
    dataLength = len(data)
    answer = set(map(int, answer))
    
    while i < dataLength:
        temp = data[i]
        # print(f"temp = {temp}")
        temp = set(map(int, removeFirst(temp)))

        if answer == temp:
            temp1 = data[i]
            print(f"{temp1[0]}")
            match_exists = True
        i += 1
        
    if match_exists == False:
        print("No match")
        
# gets the naximum number of times a base is consecutively repeated in dna


def getSTR(data, base):
    data_length = len(data)
    maxvalue = 0
    value = 0
    pos = 0
    previouspos = 0
    # go through the whole dna sequence
    while pos < data_length:
        
        # find the sequence in data starts at pos
        pos = data.find(base, pos)
        # pos returns -1 if it cannot find the data
        if pos == -1:
            # exits the loop
            value = 0
            break
        
        elif (pos - len(base)) == previouspos:
            
            value += 1
            previouspos = pos
            if maxvalue < value:
                maxvalue = value
        
        # if pos - the length of base are not equal to previouspos
        # base exists
        # after pos then it will come here
        else:
            value = 1
            previouspos = pos
            if maxvalue < value:
                maxvalue = value
                
        # increment position
        pos += 1
    
    return maxvalue
    
# remove first varible from int set


def removeFirst(data):
    # get length of data
    dataLength = len(data)
    # create an new set
    answer = [0] * (dataLength-1)
    # go throungh the whole set
    for i in range((dataLength-1)):
        answer[i] = data[i+1]

    # return the new set
    return answer


main()
