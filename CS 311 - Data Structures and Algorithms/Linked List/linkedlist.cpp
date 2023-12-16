//CS311 Yoshii S22 Linked List class

//INSTRUCTION:
//It helps to first create if-then-else structure to fill in later.
//- Make sure PURPOSE and PARAMETER comments are given in detail
//  Highly recommended to copy HW3P1-help as PURPOSE of each function.
//  Add sufficient comments to your code body to describe what it does.
//      - Make sure all if-then-else are commented describing which case it is
//      - Make sure all local variables are described fully with their purposes

//You must complete the TODO parts and then complete LinkedList.cpp. Delete "TODO" after you are done.

// ====================================================
//Your name: ??? (TODO: Add your name)
//Complier:  g++
//File type: linkedList.cpp implementation file
//=====================================================

#include<iostream>
#include"linkedlist.h"

using namespace std;

/**
 * @brief Destructor to destroy all nodes and release memory
 */
LinkedList::~LinkedList() {
    //TODO: Add code here. Make sure memory is released properly.
    while(front != rear){
        Node *temp = front->next;
        delete front;
        front = temp;
    }
    delete front;
    front = rear = nullptr;
    count = 0;
}

/**
 * @brief Purpose: Checks if the list is empty
 * @return true if the list is empty, false otherwise
 */
bool LinkedList::isEmpty() const {
    // TODO: Add code here
    return count == 0;
} 

/**
 * @brief  Get the number of nodes in the list
 * @return int The number of nodes in the list
 */
int LinkedList::length() const{
    //TODO: Add code here
    return count;
}

/**
 * @brief Convert the list to a string
 *
 */
string LinkedList::toString() {
    string str = "[";
    Node *ptr = front;
    if (ptr != nullptr) {
        // Head node is not preceded by separator
        str += to_string(ptr->val);
        ptr = ptr->next;
    }
    while (ptr != nullptr) {
        str += ", " + to_string(ptr->val);
        ptr = ptr->next;
    }
    str  += "]";
    return str;
}

/**
 * @brief Displays the contents of the list
 */
void LinkedList::displayAll() {
    cout << toString() << endl;
}

//TODO: Add comments
void LinkedList::addRear(T val) {
    // TODO: Add code here
    // consider the two cases of whether the list was empty
    if(isEmpty()){
        front = new Node(val);
        rear = front;
    }else{
        rear->next = new Node (val);
        rear = rear->next;
    }
    rear->next = nullptr;
    count++;
}

//TODO: Add comments
void LinkedList::addFront(T val) {
    // TODO: Add code here
    if(isEmpty()){
        front = new Node(val);
        rear = front;
    }else{
        Node *temp = front;
        front = new Node(val);
        front->next = temp;
    }
    count++;
    // consider the two cases of whether the list was empty
} 

//TODO: Add comments
bool LinkedList::deleteFront(T &OldNum) {
    // TODO: Add code here
    // consider if the list was empty and return false if the list is empty
    // consider the special case of deleting the only node in the list
    if(isEmpty()){
        return false;
    }else if(count == 1){
        OldNum = front->val;
        delete front;
        front = rear = nullptr;
        count = 0;
        return OldNum;
    }else{
        Node *temp = front->next;
        OldNum = front->val;
        delete front;
        front = temp;
        count--;
        return OldNum;
    }
} 


//TODO: Add comments
bool LinkedList::deleteRear(T &OldNum) {
    // TODO: Add code here
    // consider if the list was empty and return false if the list is empty
    // consider the special case of deleting the only node in the list
    if(isEmpty()){
        return false;
    }else if(count == 1){
        Node *temp = rear;
        OldNum = temp->val;
        delete rear;
        front = rear = nullptr;
        count--;
        return OldNum;
    }else{
        Node *temp;
        for(temp = front;temp->next!=rear;temp = temp->next)
            ;
        OldNum = rear->val;
        delete rear;
        rear = temp;
        rear->next = nullptr;
        count--;
        return OldNum;
    }
}

/* --- harder ones for test 2 and 3 -- */

/**
     * @brief Delete a node at a given position from the list. The
     * node at position pos is deleted and the value of the deleted node is returned in val.
     * The valid range of pos is 1 to count. pos = 1 is the first node, and pos = count is the last node.
     * @param pos: position of the node to be deleted
     * @param val: it is set to the value of the node to be deleted
     * @return true: if the node was deleted successfully
     * @return false: if the node was not deleted successfully because the position was out of range
    */
bool LinkedList::deleteAt(int pos, T &val) {
    //TODO: Add code here
    // check if the pos is valid first, then move the ptr to the rigth positon
    // consider the special case of deleting the first node and the last node
    // Do not forget to set value.
    //cout << endl << count << endl;
    
    if(pos < 0 || pos+1> count){
        return false;
    }else if(pos == 0){
        deleteFront(val);
        return val;
    } else if(pos == count-1){
        deleteRear(val);
        return val;
    }

    Node *temp2 = front;
    for(int i = 0; i<pos-1;i++){
        temp2 =temp2->next;
        if(temp2->next==nullptr){
            return false;
        }
    }

    Node *temp = front;
    temp = temp2->next;
    temp2->next = temp2->next->next;
    val = temp->val;
    delete temp;
    count--;
    return val;

}

/**
     * @brief Insert a value at a specified position in the list. The valid pos is in the range of 1 to count+1.
     * The value will be inserted before the node at the specified position. if pos = 1, the value will be inserted
     * at the front of the list. if pos = count+1, the value will be inserted at the rear of the list.
     * @param pos: position to insert the value at.
     * @param val: value to insert.
     * @return true: if the value was inserted.
     * @return false: if the value was not inserted because pos is out of the range.
     */
bool LinkedList::insertAt(int pos, T val) {
    //TODO: Add code here
    // check if the pos is valid first, then move the ptr to the rigth positon
    // consider the special case of inserting the first node and the last node
    
    if(pos < 0 || pos > count){
        return false;
    }else if(pos == 0){
        addFront(val);
        return true;
    }else if(pos == count   ){
        addRear(val);
        return true;
    }

    Node *temp2 = front;
    for(int i = 0; i<pos-1;i++){
        temp2 =temp2->next;
        if(temp2==nullptr){
            return false;
        }
    }
    Node *temp = new Node(val);
    temp->next = temp2->next;
    temp2->next = temp;
    count++;
    return true;
}

/**
 * @brief Copy Constructor to allow pass by value and return by value of a LinkedList
 * @param other LinkedList to be copied
 */
LinkedList::LinkedList(const LinkedList &other) {
    // Start with an empty list
    front = nullptr;
    rear = nullptr;
    count = 0;
    // TODO: Add code here. Interate through the other list and add a new node to this list
    // for each node in the other list. The new node should have the same value as the other node.
    Node *ptr = other.front;
    while(ptr!=nullptr){
        addRear(ptr->val);
        ptr = ptr->next;
    }
}

/**
 * @brief Overloading of = (returns a reference to a LinkedList)
 * @param other LinkedList to be copied
 * @return reference to a LinkedList
 */
LinkedList &LinkedList::operator=(const LinkedList &other) {
    if(this != &other) { // check if the same object
        // Delete all nodes in this list
        Node *temp = front;
        while(temp!=nullptr){
            Node *temp2 =temp->next;
            delete temp;
            temp = temp2;
        }
        front = nullptr;
        rear = nullptr;
        count = 0;
        // TODO: Add code here
        // Interate through the other list and add a new node to this list
        // Be sure to set the front and rear pointers to the correct values
        // Be sure to set the count to the correct value
        Node *ptr = other.front;
        while(ptr!=nullptr){
            addRear(ptr->val);
            ptr = ptr->next;
        }   
        // TODO: Add code here
    }
    return *this;
}

