#include <stdio.h>
int main()
{
  int n, dm;

  scanf("%d", &n);
  scanf("%d", &dm);

  int d[n];

  //read days of years:
  for (int i = 0; i < n; i++) {
    scanf("%d", &d[i]);
  }

  int j = 0;
  while(dm < d[j] && j < n) {
    j++;
  }
  if (j == n) {
    printf("It had never snowed this early!\n");
  } else {
    printf("It hadn't snowed this early in %d years!\n", j);
  }

  return 0;
}
