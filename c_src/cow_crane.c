#include <stdio.h>
#include <stdlib.h>
int main() {
  int m_curr, l_curr, m_des, l_des, m_time, l_time;

  scanf("%d", &m_curr);
  scanf("%d", &l_curr);
  scanf("%d", &m_des);
  scanf("%d", &l_des);
  scanf("%d", &m_time);
  scanf("%d", &l_time);

  int tom = abs(m_curr);
  int tol = abs(l_curr);

  int ltoL = abs(l_curr - l_des);
  int mtoM = abs(m_curr - m_des);

  int Ltom = abs(l_des - m_curr);
  int Mtol = abs(m_des - l_curr);

  int ltom = abs(l_curr - m_curr);

  if ((tom + mtoM <= m_time && (tom + mtoM + Mtol + ltoL) <= l_time) ||
      (tol + ltoL <= l_time && (tol + ltoL + Ltom + mtoM) <= m_time) ||
      (tol + ltom + mtoM <= m_time && tol + ltom + mtoM + mtoM + Ltom <= l_time) ||
      (tom + ltom + ltoL <= l_time && tom + ltom + ltoL + ltoL + Mtol <= m_time)) {
    printf("%s\n", "possible");
  } else {
    printf("%s\n", "impossible");
  }

  return 0;
}
