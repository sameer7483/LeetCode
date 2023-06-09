func nextGreatestLetter(letters []byte, target byte) byte {
    lo := 0
    hi := len(letters)-1
    for lo < hi {
        mid := lo + (hi-lo)/2
        if letters[mid] <= target {
            lo = mid+1
        } else {
            hi = mid
        }     
    }
    res := letters[0]
    if letters[lo] > target {
        res = letters[lo]
    }   
    return res
}