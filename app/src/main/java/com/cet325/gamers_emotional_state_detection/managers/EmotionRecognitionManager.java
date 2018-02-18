package com.cet325.gamers_emotional_state_detection.managers;

import com.cet325.gamers_emotional_state_detection.handlers.EmotionRecognitionApiHandler;
import com.cet325.gamers_emotional_state_detection.holders.ImageHolder;

public class EmotionRecognitionManager {
    private ImageHolder imageHolder;
    private EmotionRecognitionApiHandler erah;
    private int currentImageHolderSize;
    private boolean thereIsANewImage = false;

    public EmotionRecognitionManager() {
        imageHolder = ImageHolder.getInstance();
        currentImageHolderSize = 0;
    }

    public String createEmotionRequiest() {
        thereIsANewImage = checkForNewImage();
//        List<int, String> result = new ArrayList();
        if(thereIsANewImage)
        {
            erah = new EmotionRecognitionApiHandler();
            String currentEmotion = erah.runEmotionalFaceRecognition(imageHolder.getImages().get(currentImageHolderSize - 1), currentImageHolderSize);
            return currentEmotion;
        }
        return null;

    }

    private boolean checkForNewImage() {

        if(imageHolder.getImages().size() == currentImageHolderSize) {
            //there is no new image
            return false;
        }
        else if(imageHolder.getImages().size() > currentImageHolderSize) {
            //there is new image
            currentImageHolderSize++;
            return true;
        }

        return false;
    }
}
