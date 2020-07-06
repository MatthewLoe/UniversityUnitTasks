#Matthew Loe
#Student ID: 19452425
#Date Created: 26/10/2018
#Date Last Modified: 26/10/2018

CC = gcc
CFLAGS = -Wall -ansi -pedantic
EXE = TestExe
OBJ = Test.o Prac9.o
MATH = -lm

$(EXE): $(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o $(EXE) $(MATH)

Test.o: Test.c Prac9.h
	$(CC) $(CFLAGS) Test.c -c

Prac9.o: Prac9.c Prac9.h
	$(CC) $(CFLAGS) Prac9.c -c

clean:
	rm -f $(EXE) $(OBJ)

