#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max number of candidates
#define MAX 9

// Candidates have name and vote count
typedef struct
{
    string name;
    int votes;
}
candidate;

// Array of candidates
candidate candidates[MAX];

// Number of candidates
int candidate_count;

// Function prototypes
bool vote(string name);
void print_winner(void);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: plurality [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    if (candidate_count > MAX)
    {
        printf("Maximum number of candidates is %i\n", MAX);
        return 2;
    }
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
    }

    int voter_count = get_int("Number of voters: ");

    // Loop over all voters
    for (int i = 0; i < voter_count; i++)
    {
        string name = get_string("Vote: ");

        // Check for invalid vote
        if (!vote(name))
        {
            printf("Invalid vote.\n");
            i--;
        }
    }

    // Display winner of election
    print_winner();
}

// Update vote totals given a new vote
bool vote(string name)
{
    bool flag = false;

    for (int i = 0; i != candidate_count; i++)
    {
        // goes through all entries in candidate
        if (strcmp(name, candidates[i].name) == 0)
        {
            //if vote and entries are equal then add the voter count
            candidates[i].votes++;
            flag = true;
        }
    }
    if (!flag)
    {
        return flag;
    }
    return flag;
}

// Print the winner (or winners) of the election
void print_winner(void)
{
    int maxVotes = 0;
    string temp[candidate_count];
    int here = 0;
    for (int i = 0; i != candidate_count; i++)
    {
        for (int j = 0; j != candidate_count; j++)
        {
            if (candidates[i].votes > maxVotes)
            {
                maxVotes = candidates[i].votes;
            }
        }
    }
    for (int i = 0; i != candidate_count; i++)
    {
        if (candidates[i].votes == maxVotes)
        {
            temp[here] = candidates[i].name;
            here++;
        }
    }
    for (int i = 0; i != here; i++)
    {
        printf("%s\n", temp[i]);
    }
}

