#include <stdio.h>
int main(int argc, char const *argv[]) {
  while (1) {
    long long number1;
    long long number2;
    if (scanf("%lli %lli", &number1, &number2) < 0) {
      break;
    }

    long long answer = number1 - number2;
    if (number1 < number2)
      answer = -answer;

    printf("%lli\n", answer);
  }
  return 0;
}
