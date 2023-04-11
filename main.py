import cv2


# define a video capture object
vid = cv2.VideoCapture(1)

while(True):

    # Capture the video frame
    # by frame
    ret, frame = vid.read()
    frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    thresh = cv2.adaptiveThreshold(
        frame, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C, cv2.THRESH_BINARY_INV, 25, 16)

    # Display the resulting frame
    cv2.imshow('frame', thresh)

    # the 'q' button is set as the
    # quitting button you may use any
    # desired button of your choice
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

vid.release()
cv2.destroyAllWindows()
