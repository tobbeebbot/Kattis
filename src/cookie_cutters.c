#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double calc_area(int * xs, int * ys, int num_points) {
  double area = 0;
  int j = num_points -1;
  for (int i = 0; i<num_points; i++) {
    area = area + (xs[j] + xs[i]) * (ys[j] - ys[i]);
    j = i;
  }
  return abs(area) / 2;
}

int main(int argc, char const *argv[]) {
  int N;
  int * xs;
  int * ys;
  int A;

  scanf("%d\n", &N);
  xs = (int *)malloc(N * sizeof(int));
  ys = (int *)malloc(N * sizeof(int));
  for (int i = 0; i < N; i++) {
    scanf("%d %d\n", &xs[i], &ys[i]);
  }
  scanf("%d\n", &A);


  printf("%f\n", calc_area(xs,ys,N));

  return 0;
}
