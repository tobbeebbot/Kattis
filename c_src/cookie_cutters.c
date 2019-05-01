#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double calc_area(long double * xs, long double * ys, int num_points) {
  long double area = 0;
  int j = num_points -1;
  for (int i = 0; i<num_points; i++) {
    area = area + (xs[j] + xs[i]) * (ys[j] - ys[i]);
    j = i;
  }
  area = area / 2;
  if (area < 0) area = -area;
  return area;
}

void find_axis_points(long double *xs, long double *ys, int num_points,
  int * leftmost_i, int * lowest_i)
{
  *leftmost_i = 0;
  *lowest_i = 0;
  for (int i = 1; i < num_points; i++) {
    if (xs[i] < xs[*leftmost_i]) {
      *leftmost_i = i;
    }
    if (ys[i] < ys[*lowest_i]) {
      *lowest_i = i;
    }
  }
}

void fit_to_axis_and_scale(long double *xs, long double *ys, int num_points,
  long double deltaX, long double deltaY, long double scale_factor)
  {
    for (int i = 0; i < num_points; i++) {
      xs[i] = (xs[i] - deltaX) * scale_factor;
      ys[i] = (ys[i] - deltaY) * scale_factor;
    }
}

void print_points(long double *xs, long double *ys, int num_points)
{
  for (int i = 0; i < num_points; i++) {
    printf("%Lf %Lf\n", xs[i], ys[i]);
  }
}

int main(int argc, char const *argv[]) {
  int N;
  long double * xs;
  long double * ys;
  long double A;

  scanf("%d\n", &N);
  xs = (long double *)malloc(N * sizeof(long double));
  ys = (long double *)malloc(N * sizeof(long double));
  for (int i = 0; i < N; i++) {
    scanf("%Lf %Lf\n", &xs[i], &ys[i]);
  }
  scanf("%Lf\n", &A);

  printf("AreaIn: %Lf\n", A);
  print_points(xs, ys, N);

  int index_x, index_y;
  find_axis_points(xs, ys, N, &index_x, &index_y);

  printf("%s\n", "After axis points");
  print_points(xs, ys, N);

  fit_to_axis_and_scale(xs, ys, N, xs[index_x], ys[index_y], 1);

  printf("%s\n", "After fitting");
  print_points(xs, ys, N);

  long double area = calc_area(xs,ys,N);

  printf("Area: %Lf\n", area);

  long double scale_factor = sqrt(A / area);

  fit_to_axis_and_scale(xs, ys, N, xs[index_x], ys[index_y], scale_factor);

  print_points(xs, ys, N);

  return 0;
}
