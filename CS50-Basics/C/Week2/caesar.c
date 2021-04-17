#include<stdio.h>
#include<cs50.h>
#include<string.h>
#include <stdlib.h>
#include<ctype.h>
#include<ctype.h>

void caesar(string str, int key);
string numberToWord(int i);
int isAPartInInt(int i);
int parseTillKey(int answer, int key);
bool isCapital(int i);

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        return 1;
    }
    string s = argv[1];
    int strLength = strlen(s);
    bool toContinue = true;
    for (int i = 0; i != strLength; i++)
    {
        if (isAPartInInt(s[i]))
        {
            toContinue = false;
            break;
        }
    }
    if (toContinue)
    {
        if (argv[1] != '\0')
        {
            int key = atoi(argv[1]) % 26;
            if (key != 0)
            {
                string sentence = get_string("plaintext:");
                caesar(sentence, key);
            }
            else
            {
                printf("%s %s\n", argv[0], argv[1]);
            }   
        }
        else
        {
            return 1;
        }
    }
    else
    {
        return 1;
    }
}

void caesar(string str, int key)
{
    printf("ciphertext:");
    int strLength = strlen(str);
    for (int i = 0; i < strLength; i++)
    {
        int letter = str[i];
        if (isAPartInInt(letter) == 1)
        {
            int parsedInt = parseTillKey(letter, key);
            printf("%s", numberToWord(parsedInt));
        }
        else
        {
            printf("%c", str[i]);
        }
    }
    printf("\n");
}

bool isCapital(int i)
{
    if (i >= 97 && i <= 122)
    {
        return false;
    }
    if (i >= 65 && i <= 90)
    {
        return true;
    }
    return false;
}

int parseTillKey(int answer, int key)
{
    for (int i = 0; i != key; i++)
    {
        if (answer == 122 || answer == 90)
        {
            answer -= 25;
        }
        else
        {
            answer++;
        }
    }
    return answer;
}

int isAPartInInt(int i)
{
    if (i >= 97 && i <= 122)
    {
        return 1;
    }
    if (i >= 65 && i <= 90)
    {
        return 1;
    }
    else
    {
        return 0;
    }
    return 0;
}

string numberToWord(int i)
{
    if (isCapital(i))
    {
        if (i == 65)
        {
            return "A";
        }
        if (i == 66)
        {
            return "B";
        }
        if (i == 67)
        {
            return "C";
        }
        if (i == 68)
        {
            return "D";
        }
        if (i == 69)
        {
            return "E";
        }
        if (i == 70)
        {
            return "F";
        }
        if (i == 71)
        {
            return "G";
        }
        if (i == 72)
        {
            return "H";
        }
        if (i == 73)
        {
            return "I";
        }
        if (i == 74)
        {
            return "J";
        }
        if (i == 75)
        {
            return "K";
        }
        if (i == 76)
        {
            return "L";
        }
        if (i == 77)
        {
            return "M";
        }
        if (i == 78)
        {
            return "N";
        }
        if (i == 79)
        {
            return "O";
        }
        if (i == 80)
        {
            return "P";
        }
        if (i == 81)
        {
            return "Q";
        }
        if (i == 82)
        {
            return "R";
        }
        if (i == 83)
        {
            return "S";
        }
        if (i == 84)
        {
            return "T";
        }
        if (i == 85)
        {
            return "U";
        }
        if (i == 86)
        {
            return "V";
        }
        if (i == 87)
        {
            return "W";
        }
        if (i == 88)
        {
            return "X";
        }
        if (i == 89)
        {
            return "Y";
        }
        if (i == 90)
        {
            return "Z";
        }
    }
    else
    {
        if (i == 97)
        {
            return "a";
        }
        if (i == 98)
        {
            return "b";
        }
        if (i == 99)
        {
            return "c";
        }
        if (i == 100)
        {
            return "d";
        }
        if (i == 101)
        {
            return "e";
        }
        if (i == 102)
        {
            return "f";
        }
        if (i == 103)
        {
            return "g";
        }
        if (i == 104)
        {
            return "h";
        }
        if (i == 105)
        {
            return "i";
        }
        if (i == 106)
        {
            return "j";
        }
        if (i == 107)
        {
            return "k";
        }
        if (i == 108)
        {
            return "l";
        }
        if (i == 109)
        {
            return "m";
        }
        if (i == 110)
        {
            return "n";
        }
        if (i == 111)
        {
            return "o";
        }
        if (i == 112)
        {
            return "p";
        }
        if (i == 113)
        {
            return "q";
        }
        if (i == 114)
        {
            return "r";
        }
        if (i == 115)
        {
            return "s";
        }
        if (i == 116)
        {
            return "t";
        }
        if (i == 117)
        {
            return "u";
        }
        if (i == 118)
        {
            return "v";
        }
        if (i == 119)
        {
            return "w";
        }
        if (i == 120)
        {
            return "x";
        }
        if (i == 121)
        {
            return "y";
        }
        if (i == 122)
        {
            return "z";
        }
    }
    return "null";
}