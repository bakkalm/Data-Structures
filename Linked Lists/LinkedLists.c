#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node *next;
} Node;

typedef struct linked_list
{
    Node *head;
} linked_list;

// Create a new node :
Node *New_Node(int data)
{
    Node *n;
    n = malloc(sizeof(Node));
    n->data = data;
    n->next = NULL;

    return n;
}

// Create a new linked list :
linked_list *New_Linked_List(int data)
{
    Node *n = New_Node(data);

    linked_list *l = malloc(sizeof(linked_list));
    l->head = n;

    return l;
}

void Traverse(linked_list *l)
{
    // Temporary pointer to point to head :
    Node *temp = l->head;

    // Iterating over linked list :
    while (temp != NULL)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }

    printf("\n");
}

// INSERTING :
void Insert_At_Beginning(linked_list *l, Node *n)
{
    n->next = l->head;
    l->head = n;
}

void Insert_At_End(linked_list *l, Node *n)
{
    Node *temp = l->head;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    temp->next = n;
}

// Middle
void Insert_After_Node(Node *SpecificNode, Node *n)
{
    n->next = SpecificNode->next;
    SpecificNode->next = n;
}

// DELETING
void Delete(linked_list *l, Node *n)
{
    Node *temp = l->head;

    // Node to delete is the head
    if (temp == n)
    {
        l->head = n->next;
        free(n);
    }
    else
    {
        while (temp != NULL)
        {
            if (temp->next == n)
            {
                temp->next = n->next;
                free(n);
                break;
            }
            temp = temp->next;
        }
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    linked_list *l = New_Linked_List(1);

    // New nodes to insert in linekd list :
    Node *a, *b, *c;
    a = New_Node(2);
    b = New_Node(3);
    c = New_Node(4);

    //connecting to linked list
    /*
     ----     ----     ----     ----
    |head|-->| a  |-->|  b |-->|  c |-->NULL
    |____|   |____|   |____|   |____|
    */
    l->head->next = a;
    a->next = b;
    b->next = c;

    Traverse(l);

    Node *n;

    n = New_Node(0);
    Insert_At_Beginning(l, n);

    n = New_Node(-10);
    Insert_At_End(l, n);

    n = New_Node(56);
    Insert_After_Node(a, n);

    Traverse(l);

    Delete(l, l->head);
    Delete(l, n);

    Traverse(l);

    return 0;
}