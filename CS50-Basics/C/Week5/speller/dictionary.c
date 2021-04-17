// Implements a dictionary's functionality

#include <stdbool.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <strings.h>

#include "dictionary.h"

// Represents a node in a hash table
typedef struct node
{
    char word[LENGTH + 1];
    struct node *next;
}
node;

// Number of buckets in hash table
const unsigned int N = 1000000;
// Represents the size of the table
unsigned int tableSize = 0;

// Hash table
node *table[N];

// Returns true if word is in dictionary else false
bool check(const char *word)
{
    // gets the size of the word
    int n = strlen(word);
    // makes a new array of chars to store a new word
    char word_copy[LENGTH + 1];
    // puts the word int the new char array
    for (int i = 0; i < n; i++)
    {
        word_copy[i] = tolower(word[i]);
    }
    // adds a ending to the new word
    word_copy[n] = '\0';
    // hashes the new word
    int h = hash(word_copy);
    // sets the cursor to the node in the hashtable
    node *cursor = table[h];
    // checks if the words are the same or else goes to the next one
    while (cursor != NULL)
    {
        // checks if the words are the same
        if (strcasecmp(cursor->word, word_copy) == 0)
        {
            return true;
        }
        // goes to the next one if the words are not the same
        else
        {
            cursor = cursor->next;
        }
    }
    // if it doesnt find the same word then it returns false
    return false;
}

// Hashes word to a number
unsigned int hash(const char *word)
{
    // creates hash varible
    unsigned int hash = 0;
    // 
    for (int i = 0, n = strlen(word); i < n; i++)
    {
        hash = (hash << 2) ^ word[i];
    }
    return hash % N;
}

// Loads dictionary into memory, returning true if successful else false
bool load(const char *dictionary)
{
    // opens the file
    FILE *file = fopen(dictionary, "r");
    // if it is null then returns false
    if (file == NULL)
    {
        return false;
    }
    // creates char array
    char word[45];
    // scans every word and puts it in the table
    while (fscanf(file, "%s", word) != EOF)
    {
        // allocates enough memory to store a node
        node *n = malloc(sizeof(node));
        // if it cannot allocate memory to the node then returns false
        if (n == NULL)
        {
            unload();
            return false;
        }
        
        // coppies the word into the node
        strcpy(n->word, word);
        // hashes the word
        int hashedInt = hash(n->word);
        
        // if the position in the table is null
        if (table[hashedInt] == NULL)
        {
            // set the table at position to n
            table[hashedInt] = n;
            // increment the table size
            tableSize++;
        }
        // if the position in the table is not null
        else
        {
            // go to the position
            n->next = table[hashedInt];
            // set the table at position to n
            table[hashedInt] = n;
            // increment the table size
            tableSize++;
        }
    }
    // close the file
    fclose(file);
    // if it has reaches till here then the process is over
    // so it returns true
    return true;
    
}

// Returns number of words in dictionary
unsigned int size(void)
{
    // returns the size of the table
    return tableSize;
}

// Unloads dictionary from memory, returning true if successful else false
bool unload(void)
{
    for (int i = 0; i != N; i++)
    {
        free(table[i]);
    }
    return true;
}
