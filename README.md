# Simple-Translator
This program provides a literal translation for text entered by a user. To determine how to translate the words, a parallel corpus will be used. A parallel corpus is a large collection of text in two or more languages. 

The corpus will be much simpler than most corpora in that each line contains only a single word in each language, separated by a comma. The program will find the word in the first language, and replace it with its partner in the second. If the corpus does not contain a particular word, it wil be left untranslated. 

The following is an example of a parallel corpus text file (French-English):\
• The first line indicates the number of entries (you may assume this number is correct).\
• Accents on letters are ignored (for easy keyboard input).\
• Sometimes two different words might translate to the same word (“le” / ”la” both translate to “the”), but you may assume each word on the left-hand side appears only once.

## Example Input:
```
8
le,the
la,the
meduse,jellyfish
garcon,boy
danse,dances
avec,with
paresseux,lazy
puante,smelly
```

Using this corpus, a literal translator can translate:
```
Le garcon paresseux danse avec la meduse puante!
```
into:
```
The boy lazy dances with the jellyfish smelly! 
```

## Functionalites:
• Allow the user to select an option (1 or 2) for what translation is to be done (English to French OR French to English). This determines the file name of the corpus to be used for the translation. Then display a message indicating that the corpus file was successfully read.\
• Allow the user to enter some source text that is to be translated.\
• When the user commits the input by pressing on the “enter” key, translate the text and display the result. The source text may contain capital letters and/or punctuation. The program will convert it to lowercase and ignore punctuation, except if the first character in the source is capitalized, capitalize it in the result as well and if the last character in the source is punctuation (not a letter or digit), include it in the result as well. If a source word cannot be found in the corpus, just leave it untranslated.\
• Thw program will loop continuously till the user indicates that they want to quit. With each loop, prompt the user to re-enter an option to determine the filename of the corpus to be used, as well as a new source text to be translated.\
• If any exceptions are encountered, display a message to the user indicating the problem. 

## Example Output:
```
Welcome to the Translator! Bienvenue!!
You can translate sentences from English to French and vice versa!
So, what would you like to do? Please select from one of the following:
>> From English to French: (input '1')
>> From French to English: (input '2')
k
Invalid input! Input must be an integer! Try again:
2.3
Invalid input! Input must be an integer! Try again:
5
Invalid input! Input should be 1 or 2. Please try again:
1
Input the sentence for translation:
The lazy boy dances with the smelly jellyfish!
Your sentence translated is:
>> Le paresseux garcon danse avec le puante meduse!
Another translation? (y/n)
2
Invalid input! Please enter 'y' or 'n':
Y
So, what would you like to do? Please select from one of the following:
>> From English to French: (input '1')
>> From French to English: (input '2')
2
Input the sentence for translation:
Invalid (empty) string!
Input the sentence for translation:
Le meduse puante Chacha.
Your sentence translated is:
>> The jellyfish smelly chacha.
Another translation? (y/n)
n
```
