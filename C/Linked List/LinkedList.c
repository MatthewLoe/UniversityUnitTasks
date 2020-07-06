/*Matthew Loe
  Student ID: 19452425
  Date Created: 1/10/2018
  Date Last Modified: 2/10/2018 */

#include "LinkedList.h"

LinkedList* newLinkedList(void)
{
    LinkedList* list;

    list = (LinkedList*)malloc(sizeof(LinkedList));
    list->head = NULL;
    list->tail = NULL;

    return list;
}

void insertFirst(LinkedList* list, void* value)
{
    LinkedListNode* newNode = (LinkedListNode*)malloc(sizeof(LinkedListNode));

    newNode->data = *value;
    newNode->next = head;
    newNode->prev = NULL;

    if (list->head != NULL)
    {
        newNode->prev = list->head;
    }
    else
    {
        list->tail = newNode;
    }
    /*END IF */

    list->head = newNode; 
}

void insertLast(LinkedList* list, void* value)
{
    LinkedListNode* newNode = (LinkedListNode*)malloc(sizeof(LinkedListNode));

    newNode->data = *value;
    newNode->next = NULL;

    newNode->prev = list->tail;

    if (list->tail != NULL)
    {
        (list->tail)->next = newNode;
    }
    else
    {
        list->head = newNode;
    }
    /*END IF */

    list->tail = newNode; 
}

void* removeFirst(LinkedList* list)
{
    LinkedListNode* node;
    void* value;

    node = list->head;
    value = node->data;

    list->head = node->next;

    if (list->head != NULL)
    {
        (list->head)->prev = NULL;
    }
    /*END IF */

    free(node);
    node = NULL;

    return value; 
}

int isEmpty(LinkedList* list)
{
    int num = TRUE;

    if (list->head != NULL)
    {
        num = FALSE;
    }
    /*END IF */

    return num;
}

void* removeLast(LinkedList* list)
{
    LinkedListNode* node;
    void* value;

    node = list->tail;
    value = node->data;

    list->tail = node->prev;
    if (list->tail != NULL)
    {
        (list->tail)->next = NULL;
    }
    /*END IF */

    free(node);
    node = NULL;

    return value;
}

void freeLinkedList(LinkedList* list)
{
    freeNode(list->head);
    free(list);
    list = NULL;
}

void freeNode(LinkedListNode* node)
{
    if(node != NULL)
    {
        freeNode(node->next);
        
        free(node->data);
        node->data = NULL;
        free(node);
        node = NULL;
    }
    /*END IF */

}




