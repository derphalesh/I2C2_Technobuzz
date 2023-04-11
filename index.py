import urllib.request
import cv2 as cv  # Please install with PIP: pip install cv2
import numpy as np

frame = None
cap = None
key = None


print('START')
while True:
    imgResponse = urllib.request.urlopen('http://192.168.1.32/capture?')
    imgNp = np.array(bytearray(imgResponse.read()), dtype=np.uint8)
    frame = cv.imdecode(imgNp, -1)
    frame = cv.flip(frame, 0)
    cv.imshow('Window', frame)
    key = cv.waitKey(1)
    if key == (ord('q')):
        break
cv.destroyAllWindows()
cap.release()
print('TNE END')
