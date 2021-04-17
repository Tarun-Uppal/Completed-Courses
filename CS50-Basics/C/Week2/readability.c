#include<stdio.h>
#include<cs50.h>
#include<string.h>
#include<ctype.h>
#include<math.h>

int readability(string sentence);
void getNoOf(string sentence);

double answer[3] = {0, 0, 0};

int main()
{
    string sentence = get_string("Text: ");
    int finalAnswer = readability(sentence);

    if (finalAnswer <= 0)
    {
        printf("Before Grade 1\n");
    }
    if (finalAnswer >= 16)
    {
        printf("Grade 16+\n");
    }
    else if (finalAnswer > 0 && finalAnswer < 16)
    {
        printf("Grade %i\n", finalAnswer);
    }

}

int readability(string sentence)
{
    getNoOf(sentence);
    double noOfSentences = answer[2];
    double noOfLetters = answer[0];
    double noOfWords = answer[1];

    // printf("noOfWords = %i\n",noOfWords);

    double index = 0.0588 * (100 * noOfLetters / noOfWords) - 0.296 * (100 * noOfSentences / noOfWords) - 15.8;

    index = round(index);
    return index;

}

void getNoOf(string sentence)
{
    int size = strlen(sentence);
    bool flag = true;

    for (int i = 0; i <= size; i++)
    {
        char letter = sentence[i];
        int letter1 = sentence[i];

        if (isalnum(letter))
            //counts no of letters
        {
            answer[0]++;
        }

        if (letter == ' ' || letter == ',')
        {
            flag = true;
        }
        else if (flag == true) //if next word is not empty and flag is true,
        {
            //increment word counter
            flag = false;
            answer[1]++;
        }
        if ((letter == '.') || (letter == '!') || (letter == '?'))
            //counts noOf sentences
        {
            answer[2]++;
        }
    }
    if (flag)
    {
        answer[1]++;
    }
}