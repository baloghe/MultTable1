MultTable1
==========

Java EE project for multiplication table quiz

User is asked to provide an UpperBound of a range (range := [0 - UpperBound]) and the number of questions to be asked. Then the product of two randomly chosen number (falling in the range) will be asked each time. A session variable takes care of counting the number of bad answers and both the question and the erroneous answer provided by the user. Finally a statistics is shown including accuracy (#good answers / #total questions %) and the list of bad answers including the question, the answer provided by the user and the solution.
