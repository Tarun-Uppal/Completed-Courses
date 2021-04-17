import sqlite3
import csv
import sys


def main():
    x = len(sys.argv)
    if x != 2:
        sys.exit("You must provide")
    
    sqlite_file = "students.db"
    con = sqlite3.connect(sqlite_file)
    house = sys.argv[1]
    
    cur = con.cursor()
    
    # The result of a "cursor.execute" can be iterated over by row
    for row in cur.execute("SELECT * FROM students ORDER BY last"):
        
        if row[4] in house:
            print(f"{row[1]}", end=" ")
            if row[2] != None:
                print(f"{row[2]}", end=" ")
            print(f"{row[3]}", end=", ")
            print(f"born {row[5]}")
    
    con.close()


main()
