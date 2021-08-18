# Kattis: https://open.kattis.com/problems/3dprinter
# Solved

import sys

def main():
    y = int(sys.stdin.readline())
    print(calculate(y))

def calculate(y):
    x = 1
    i = 0
    while x < y:
        x = x * 2
        i += 1

    return i + 1


if __name__ == "__main__":
    main()