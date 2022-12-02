from collections import deque

class Node:
    def __init__(self, key):
        self.key = key
        self.left = self.right = None

    def preorder(self):
        if self is not None:
            print(self.key, end=' ')
            if self.left:
                self.left.preorder()
            if self.right:
                self.right.preorder()

    def inorder(self):
        if self is not None:
            if self.left:
                self.left.inorder()
            print(self.key, end=' ')
            if self.right:
                self.right.inorder()

    def postorder(self):
        if self is not None:
            if self.left:
                self.left.postorder()
            if self.right:
                self.right.postorder()
            print(self.key, end=' ')

    def levelorder(self):
        q = deque([self])
        while q:
            node = q.popleft()
            print(node.key, end=' ')
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)

    def count_node(self):
        if self is None:
            return 0
        else:
            a, b = 0, 0
            if self.left:
                a = self.left.count_node()
            if self.right:
                b = self.right.count_node()
            return 1 + a + b

    def count_leaf(self):
        if self is None:
            return 0
        elif self.left is None and self.right is None:
            return 1
        else:
            a, b = 0, 0
            if self.left:
                a = self.left.count_leaf()
            if self.right:
                b = self.right.count_leaf()
            return a + b

    def calc_height(self):
        if self is None:
            return 0
        hLeft, hRight = 0, 0
        if self.left:
            hLeft = self.left.calc_height()
        if self.right:
            hRight = self.right.calc_height()
        if hLeft > hRight:
            return hLeft + 1
        else:
            return hRight + 1

# # 8-1-1
# N1 = Node("A")
# N2 = Node("B")
# N3 = Node("C")
# N4 = Node("D")
# N5 = Node("E")
# N6 = Node("F")
# N7 = Node("G")
# N8 = Node("H")
#
# root = N1
# N1.left = N2
# N1.right = N3
# N2.left = N4
# N3.left = N5
# N3.right = N6
# N5.left = N7
# N5.right = N8

# 8-1-2
N1 = Node("+")
N2 = Node("*")
N3 = Node("E")
N4 = Node("*")
N5 = Node("D")
N6 = Node("/")
N7 = Node("C")
N8 = Node("A")
N9 = Node("B")

root = N1
N1.left = N2
N1.right = N3
N2.left = N4
N2.right = N5
N4.left = N6
N4.right = N7
N6.left = N8
N6.right = N9

print('PreOrder')
root.preorder()

print('\nInOrder')
root.inorder()

print('\nPostOrder')
root.postorder()

print('\nLevelOrder')
root.levelorder()

print('\nCountNode')
print(root.count_node())

print('CountLeaf')
print(root.count_leaf())

print('CountHeight')
print(root.calc_height())