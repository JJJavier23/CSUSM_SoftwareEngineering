/*****************************************************
Template prepared by Kazumi Slott
CS211
lab on template functions
This header file provides useful operations on an array
of any data type.

Your name:
*****************************************************/

#include <iostream>
using namespace std;

/********************************************
This function fills the array with data entered from the keyboard.

ar is an array of any data type
n is the number of items entered into ar
********************************************/
template <class T>
void fill(T ar[], int n)
{
   for(int i = 0;i < n; i++){
     cout << "Enter an item: " << endl;
    cin >> ar[i];
  }
}



/********************************************
This function prints the array.

ar is an array of any data type
n is the number of items in ar
********************************************/
template <class T>
void print(T ar[], int n)
{
  for(int i=0;i<n;i++){
    cout << ar[i]<< " ";
 }
  cout << endl;
}


/*******************************************
This function returns the index of the highest value.

ar is an array of any data type.
n is the number of items in ar
*******************************************/
template <class T>
int getHighest(const T ar[], int n){
  int hi=0; //index#
  for(int i=0;i<n;i++){
    if(ar[i] > ar[hi]){
      hi = i;
    }
  }
  return hi;
}




/*******************************************
This function returns the index of the lowest value.

ar is an array of any data type.
n is the number of items in array
*******************************************/
template <class T>
int getLowest(const T ar[], int n){
  int low=0;
  for(int i=0;i<n;i++){
    if(ar[i]< ar[low]){
	low= i;
	  }
  }
  return low;
}




/********************************************
This function returns the average.

ar is an array of any data type.
n is the number of items in ar
********************************************/
template <class T>
double getAvg(const T ar[], int n){
  int index;
  double avg;
  for(int i=0;i<n;i++){
    avg+=ar[i];
    index = i;
  }
  avg=avg/(index+1);

  return avg;
}



/*******************************************
This function stores unique items into an array
and returns the number of the unique items.
  e.g.  If ar contains  9 3 5 3 9 1 9
        uniqAr gets 9 3 5 1
        The function returns 4  
       
ar is the original array of any data type
uniqAr is the array that will have only unique items
n is the number of items in ar
*******************************************/
template <class T>
int unique(const T ar[], T uniqAr[], int n)
{
 
//uniqAr in the caller will be filled with only unique numbers

  int countUniq=0;
  for(int i=0;i<n;i++){
    T value=ar[i];
    bool found = false;
    for(int j=0;j<countUniq;j++){
      if(uniqAr[j]==value){
	found=true;
	break;
      }
    }
    if(!found){
      uniqAr[countUniq]=value;
      countUniq++;
    }
  }
  return countUniq;
}




/***********************************************
This function sorts the items in ascending order: smallest to largest

array is an array of any data type
N is the number of items in the array
**********************************************/                                                

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//The following function sorts an integer array in ascending order 
//using the selection sort algorithm.
//You need to change this code so it works with an array of any data type.
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
template <class T>
void sort(T array[], int N)
{
  int lrgIndx; //the index of the largest value                                                                                               
  T temp; //temporary variable that holds the largest value                                                                                  

  //last is the last index in unsorted portion                                                                                                 
  for(int last = N-1; last >= 1; last--)
    {
      lrgIndx = 0; //assume the first item is the largest                                                                                      
      //find the largest in unsorted portion ([0..last])                                                                                       
      for(int i = 1; i <= last; i++)
        {
          if(array[i] > array[lrgIndx]) //The current item is larger                                                                           
            lrgIndx = i;
        }

      //swap the largest with the last item in the unsorted portion                                                                            
      temp = array[lrgIndx];
      array[lrgIndx] = array[last];
      array[last] = temp;
    }
}

/*******************************************
This function sorts the array in descending order: largest to smallest
array an array of any data type
N is the number of items in the array

The following function sorts the array in descending order using the bubble sort algorithm.
 ******************************************/
template <class T>
void bubbleSort(T array[], int N){
  bool done=true; //bool typing to make sure to go through each "bubble" until sorted
  T temp; //temporary variable to swap and put number in largest to smallest order
  while(done ==true){
    done = false;
    for(int i=0;i<N;i++){ //for loop to go through each number in array
      if(array[i]<array[i+1]){ //the bubble sort checking the value of the index next to initial index
	temp=array[i+1];
	array[i+1]=array[i];
	array[i]=temp;
	done=true;
 //setting back to true in order to continue through array to bubble sort
      }
    }
  }
}

template <class T>
int find(const T ar[], int N, const T& key){
  for(int i = 0; i < N; i++){
    if(ar[i] == key){
      return i;
    }
  }
  return -1;
}

template <class T>
bool remove(T ar[], int N, T key){
  int index = find(ar, N, key);
  if(index==-1){
    return false;
  }
    for(int i = index;i < N;i++){
      ar[i]=ar[i+1];
  }
  return true;
}
