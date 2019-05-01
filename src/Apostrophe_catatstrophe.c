#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define SIZE 280

int plus_or_minus(char * c) {
  return *c == '+' || *c == '-';
}

int main(int argc, char const *argv[]) {
  char * line1 = (char*)malloc(SIZE);
  char * line2 = (char*)malloc(SIZE);

  size_t size = SIZE;
  getline(&line1, &size, stdin);
  getline(&line2, &size, stdin);

  char * ptr1 = line1;
  char * ptr2 = line2;
  int since_last = 0;
  int match_count = 0;
  int curr_pluses = 0;
  char * buffer = (char *)malloc(SIZE);
  while(!plus_or_minus(ptr1)) {
    ptr1++;
    ptr2++;
  }
  //ptr1 now pointing on first +/-
  while(plus_or_minus(ptr1)) {
    ptr1++;
  }
  while(!plus_or_minus(ptr1)) {
    buffer[since_last++] = *ptr1;
    ptr1++;
  }
  buffer[since_last] = '\0';
  printf("%s\n", buffer);

  char * found = strstr(ptr2,buffer);
  int length = found - ptr2;
  char * result = (char *)malloc(length);
  memcpy(result,ptr2,length);
  ptr2 = found + since_last;

  printf("%s\n", result);

  return 0;
}
