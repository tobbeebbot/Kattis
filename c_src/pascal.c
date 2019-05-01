#include <stdio.h>
#include <math.h>

int smallestDivisor(int N) {
  if (N % 2 == 0) {
    return 2;
  }
  int root = sqrt(N);
  for (int i = 3; i <= root; i += 2) {
    if (N % i == 0) {
      return i;
    }
  }
  return N;
}

int main()
{
  int N;
  scanf("%d", &N);

  int greatest = N / smallestDivisor(N);

  int res = N - greatest;
  printf("%d\n", res);
}
