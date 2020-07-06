/*Matthew Loe
  Student ID: 19452425
  Date Created: 1/10/2018
  Date Last Modified: 2/10/2018 */

#ifndef STDLIB
    #define STDLIB
    #include <stdlib>
#endif

#ifndef TRUE/FALSE
    #define TRUE/FALSE
    #define FALSE 0
    #define TRUE !FALSE
#endif

typedef struct LinkedListNode
{
    void* data;
    struct LinkedListNode* next;
    struct LinkedListNode* prev;
} LinkedListNode;

typedef struct 
{
    LinkedListNode* head;
    LinkedListNode* tail;
} LinkedList;

LinkedList* newLinkedList(void);
void insertFirst(LinkedList* list, void* value);
void insertLast(LinkedList* list, void* value);
void* removeFirst(LinkedList* list)
void* removeLast(LinkedList* list)
int isEmpty(LinkedList list);
void freeLinkedList(LinkedList* list)
void freeNode(LinkedListNode* node)

