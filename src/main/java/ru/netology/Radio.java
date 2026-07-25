package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationCount;

    // Конструктор без параметров (по умолчанию 10 станций)
    public Radio() {
        this.stationCount = 10;
    }

    // Конструктор с параметром (задаём количество станций)
    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getStationCount() {
        return stationCount;
    }

    public void setCurrentStation(int newStation) {
        if (newStation < 0) {
            return;
        }
        if (newStation >= stationCount) {
            return;
        }
        currentStation = newStation;
    }

    public void next() {
        if (currentStation < stationCount - 1) {
            currentStation = currentStation + 1;
        } else {
            currentStation = 0;
        }
    }

    public void prev() {
        if (currentStation > 0) {
            currentStation = currentStation - 1;
        } else {
            currentStation = stationCount - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }
}