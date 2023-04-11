import cv2

im = cv2.imread('parking3.png')

print(type(im))
# <class 'numpy.ndarray'>

print(im.shape)
image = cv2.resize(im, (720, 434))
image_gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
thresh = cv2.adaptiveThreshold(
    image_gray, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, 25, 16)

cv2.rectangle(image, (45, 230), (310, 365), (255, 0, 255), 2)
cv2.rectangle(image, (45, 50), (310, 185), (255, 0, 255), 2)

cv2.imshow('frame', image)
cv2.waitKey(0)

cv2.imshow('frame', image_gray)
cv2.waitKey(0)


cv2.imshow('frame', thresh)
print("Parking slot 1 (Pixel count): ",
      cv2.countNonZero(thresh[50:185, 45:310]))
print("Parking slot 3 (Pixel count): ",
      cv2.countNonZero(thresh[230:365, 45:310]))
cv2.waitKey(0)


cv2.destroyAllWindows()
