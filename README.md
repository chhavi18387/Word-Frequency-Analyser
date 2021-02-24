# Word-Frequency-Analyser
Word frequency analyser: can handle multiple files ssing multithreading. 


* FileReaderRunnable : it is used to read the file and parse through it. Inside run fuction, each line is processed using Scanner object and words in each line are appened to hashmap to store a count of how many times a particular word occured in the  text. If the key== current_word doesn't exist, a new key is created.


* WordSetSorter : Sorts the hashmap of words 


* ThreadManager is used to handle multiple files at a time.
