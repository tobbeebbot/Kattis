#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double calc_area(double * xs, double * ys, int num_points) {
  double area = 0;
  int j = num_points -1;
  for (int i = 0; i<num_points; i++) {
    area = area + (xs[j] + xs[i]) * (ys[j] - ys[i]);
    j = i;
  }
  area = area / 2;
  if (area < 0) area = -area;
  return area;
}

void find_axis_points(double *xs, double *ys, int num_points,
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

void fit_to_axis_and_scale(double *xs, double *ys, int num_points,
  double deltaX, double deltaY, double scale_factor)
  {
    for (int i = 0; i < num_points; i++) {
      xs[i] = (xs[i] - deltaX) * scale_factor;
      ys[i] = (ys[i] - deltaY) * scale_factor;
    }
}

void print_points(double *xs, double *ys, int num_points)
{
  for (int i = 0; i < num_points; i++) {
    printf("%lf %lf\n", xs[i], ys[i]);
  }
}

int main(int argc, char const *argv[]) {
  int N;
  double * xs;
  double * ys;
  double A;

  scanf("%d\n", &N);
  xs = (double *)malloc(N * sizeof(double));
  ys = (double *)malloc(N * sizeof(double));
  for (int i = 0; i < N; i++) {
    scanf("%lf %lf\n", &xs[i], &ys[i]);
  }
  scanf("%lf\n", &A);

  int index_x, index_y;
  find_axis_points(xs, ys, N, &index_x, &index_y);

  fit_to_axis_and_scale(xs, ys, N, xs[index_x], ys[index_y], 1);

  double area = calc_area(xs,ys,N);

  double scale_factor = sqrt(A / area);

  fit_to_axis_and_scale(xs, ys, N, xs[index_x], ys[index_y], scale_factor);

  print_points(xs, ys, N);

  return 0;
}
