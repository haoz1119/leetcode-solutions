# Last updated: 11/21/2025, 5:27:34 PM
class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.end = True

    def search(self, word: str) -> bool:
        def dfs(d: int, node: TrieNode)->bool:
            if d >= l:
                return node.end
            ch = word[d]
            if ch != '.':
                if ch in node.children:
                    return dfs(d+1, node.children[ch])
                else: return False
            else:
                res = False
                for key in node.children.keys():
                    t = dfs(d+1, node.children[key])
                    res = t or res
                return res
        l = len(word)
        return dfs(0, self.root)
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)