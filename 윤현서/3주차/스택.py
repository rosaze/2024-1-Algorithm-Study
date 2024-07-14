#기본 스택 구조 복습
import sys

class Stack:
    def __init__(self):
        self.lst = list()

    def pushX(self, n):
        self.lst.append(n)

    def pop(self):
        if self.lst:
            print(self.lst.pop())
        else:
            print(-1)

    def size(self):
        print(len(self.lst))

    def empty(self):
        if self.lst:
            print(0)
        else:
            print(1)

    def top(self):
        if self.lst:
            print(self.lst[-1])
        else:
            print(-1)


n = int(sys.stdin.readline().rstrip())
s = Stack()
for _ in range(n):
    st = sys.stdin.readline().rstrip()

    if ' ' in st:
        method, n = st.split()
        s.pushX(int(n))
    else:
        if st == 'pop':
            s.pop()
        elif st == 'size':
            s.size()
        elif st == 'empty':
            s.empty()
        else:
            s.top()