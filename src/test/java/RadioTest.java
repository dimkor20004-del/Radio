package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    // ===== ТЕСТЫ НА КОНСТРУКТОРЫ =====

    @Test
    public void testDefaultConstructorStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
    }

    @Test
    public void testCustomConstructorStationCount() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getStationCount());
    }

    // ===== ТЕСТЫ НА СТАНЦИИ (10 станций, конструктор по умолчанию) =====

    @Test
    public void testSetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetStationBelowZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(-1);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetStationAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.setCurrentStation(10);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetStationZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void testNextStationFromMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationFromZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // ===== ТЕСТЫ НА СТАНЦИИ (кастомное количество станций) =====

    @Test
    public void testCustomStationCountNextFromMax() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testCustomStationCountPrevFromZero() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testCustomStationCountSetAboveMax() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(5);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testCustomStationCountSetMax() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(4);
        assertEquals(4, radio.getCurrentStation());
    }

    // ===== ТЕСТЫ НА ГРОМКОСТЬ =====

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeFromMax() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            radio.increaseVolume();
        }
        radio.decreaseVolume();
        assertEquals(9, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeFromMin() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testInitialStationIsZero() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testInitialVolumeIsZero() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentVolume());
    }

    // ===== ТЕСТЫ НА ГРОМКОСТЬ С КАСТОМНЫМ КОНСТРУКТОРОМ =====

    @Test
    public void testCustomRadioVolumeWorks() {
        Radio radio = new Radio(20);
        for (int i = 0; i < 50; i++) {
            radio.increaseVolume();
        }
        assertEquals(50, radio.getCurrentVolume());
    }
}