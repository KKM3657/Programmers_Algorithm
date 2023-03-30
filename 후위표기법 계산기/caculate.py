class Stack:
    def __init__(self):
        self.items = []

    def push(self, val):
        self.items.append(val)

    def pop(self):
        try:
            return self.items.pop()
        except IndexError:
            print("Stack is empty")

    def top(self):
        try:
            return self.items[-1]
        except IndexError:
            print("Stack is empty")

    def __len__(self):
        return len(self.items)

    def isEmpty(self):
        return self.__len__() == 0

def get_token_list(expr):
    expr = expr.replace(" ", "")
    expr = expr.replace("+", " + ")
    expr = expr.replace("-", " - ")
    expr = expr.replace("/", " / ")
    expr = expr.replace("*", " * ")
    expr = expr.replace("^", " ^ ")
    expr = expr.replace("(", " ( ")
    expr = expr.replace(")", " ) ")
    return expr.split()

def infix_to_postfix(infix):
    opstack = Stack()
    outstack = []
    token_list = list(infix)

    # 연산자의 우선순위 설정
    prec = {}
    prec['('] = 0
    prec[')'] = 5
    prec['+'] = 1
    prec['-'] = 1
    prec['*'] = 2
    prec['/'] = 2
    prec['^'] = 3

    for token in token_list:
        if token == ' ':
            continue
        if token == '(':
            opstack.push(token)
        elif token == ')':
            while True:
                token = opstack.pop()
                if token != '(':
                    outstack.append(token)
                else:
                    break

        elif token in '+-/*^':
            while (not opstack.isEmpty()) and (prec[opstack.top()] >= prec[token]):
                outstack.append(opstack.pop())
            opstack.push(token)
        else:  # operand(피연산자)일 때
            outstack.append(token)

    # opstack 에 남은 모든 연산자를 pop 후 outstack에 append
    while not opstack.isEmpty():
        outstack.append(opstack.pop())

    return " ".join(outstack)

def cal_postfix(arr):
    dig = []
    for value in arr:
        if value == " ":
            continue
        elif value in '+-/*^':
            b = dig.pop()
            a = dig.pop()

            if value == '+':
                dig.append(a + b)
            elif value == '-':
                dig.append(a - b)
            elif value == '*':
                dig.append(a * b)
            elif value == '/':
                dig.append(a / b)
            else:
                dig.append(a ** b)
        else:
            dig.append(float(value))

    return dig.pop()


expr = input()
infix_expr = get_token_list(expr)
postfix_expr = infix_to_postfix(infix_expr)
print(postfix_expr)
postfix_expr = postfix_expr.split()
result = cal_postfix(postfix_expr)
print(result)