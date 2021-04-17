from cs50 import get_string

sentence = get_string("Text: ")

size = len(sentence)
flag = True

noOfLetters = 0
noOfWords = 0
noOfSentences = 0

for i in range(size):
    letter = sentence[i]
    
    if letter.isalpha() == True:
        # counts no of letters
        noOfLetters += 1
        
    if letter == ' ' or letter == ',':
        flag = True
    
    elif flag:
        # if next word is not empty and flag is true,
        # increment word counter
        flag = False
        noOfWords += 1
    
    if letter == '.' or letter == '!' or letter == '?':
        # counts noOf  sentences
        noOfSentences += 1
        
if flag:
    noOfWords += 1

index = round(0.0588 * (100 * noOfLetters / noOfWords) - 0.296 * (100 * noOfSentences / noOfWords) - 15.8)


if index >= 16:
    print("Grade 16+")
    
elif index < 1: 
    print("Before Grade 1")
    
else:
    print(f"Grade {index}")
