class Solution:
    def simplifyPath(self, path: str) -> str:
        arr = path.split('/')
        st = []
        for ele in arr:
            if ele == '/' or ele == '.' or ele == '':
                continue
            if ele == '..' :
                if len(st) > 0:
                    st.pop()
            else:
                st.append(ele)
        res = ''
        if len(st) == 0:
            return '/'
        for i in range(len(st)):
            res += f'/{st[i]}'
        return res
                
        