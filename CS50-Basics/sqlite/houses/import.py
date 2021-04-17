import sqlite3
import csv
import sys

    
def main():
    
    filename = sys.argv[1]

    if not (filename.endswith(".csv")):
        sys.exit("You must provide a *.csv")
        
    x = len(sys.argv)
    if x != 2:
        sys.exit("You must provide a file.csv")
    
    sqlite_file = "students.db"
    con = sqlite3.connect(sqlite_file)

    cur = con.cursor()
    
    dataFile = open(sys.argv[1], "r")
    
    for line in dataFile:
        string = line.split(",")
        name = string[0].split()
        length = len(name)
        names = []
        names.append(name[0])
        if length == 2:
            names.append(name[1])
        if length == 3:
            names.append(name[1])
            names.append(name[2])
        names.append(string[1])
        names.append(string[2])
    
        if len(names) == 5:
            cur.execute("INSERT INTO students (first, middle, last, house, birth) VALUES(?, ?, ?, ?, ?)", names[:5])
        if len(names) == 4:
            cur.execute("INSERT INTO students (first, last, house, birth) VALUES(?, ?, ?, ?)", names[:4])
    
    con.commit()
    con.close()


main()