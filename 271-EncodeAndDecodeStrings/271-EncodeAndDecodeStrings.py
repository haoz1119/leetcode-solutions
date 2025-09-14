# Last updated: 9/14/2025, 12:53:44 PM
class Codec:
    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        out = ""
        for str in strs:
            out += str.replace("/", "//")+"/:"
        return out

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        ans = []
        current_str = ""
        i = 0
        while i < len(s):
            if s[i:i+2] == "/:":
                ans.append(current_str)
                current_str = ""
                i += 2
            elif s[i:i+2] == "//":
                current_str += "/"
                i += 2
            else: 
                current_str += s[i]
                i+=1
        return ans



# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))