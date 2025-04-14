package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of the tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest(TestInfo testInfo) {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter + " " + testInfo.getDisplayName());
    }

    @Nested
    @DisplayName("Tests for adding figures")
    class TestAddFigures {
        @Test
        void testAddSquare() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);

            //When
            collector.addFigure(shapeSquare);

            //Then
            Assertions.assertEquals(1, collector.getShapesQuantity());
        }

        @Test
        void testAddCircle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeCircle shapeCircle = new ShapeCircle(5);

            //When
            collector.addFigure(shapeCircle);

            //Then
            Assertions.assertEquals(1, collector.getShapesQuantity());
        }

        @Test
        void testAddTriangle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);

            //When
            collector.addFigure(shapeTriangle);

            //Then
            Assertions.assertEquals(1, collector.getShapesQuantity());
        }

        @Test
        void testAddAllShapes() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);
            ShapeCircle shapeCircle = new ShapeCircle(5);
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);

            //When
            collector.addFigure(shapeSquare);
            collector.addFigure(shapeCircle);
            collector.addFigure(shapeTriangle);

            //Then
            Assertions.assertEquals(3, collector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for removing figures")
    class TestRemoveFigures {
        @Test
        void testRemoveSquareNotExisting() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);

            //When
            boolean result = collector.removeFigure(shapeSquare);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveCircleNotExisting() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeCircle shapeCircle = new ShapeCircle(5);

            //When
            boolean result = collector.removeFigure(shapeCircle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveTriangleNotExisting() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);

            //When
            boolean result = collector.removeFigure(shapeTriangle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveSquare() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);
            collector.addFigure(shapeSquare);

            //When
            boolean result = collector.removeFigure(shapeSquare);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, collector.getShapesQuantity());
        }

        @Test
        void testRemoveCircle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeCircle shapeCircle = new ShapeCircle(5);
            collector.addFigure(shapeCircle);

            //When
            boolean result = collector.removeFigure(shapeCircle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, collector.getShapesQuantity());
        }

        @Test
        void testRemoveTriangle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);
            collector.addFigure(shapeTriangle);

            //When
            boolean result = collector.removeFigure(shapeTriangle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, collector.getShapesQuantity());
        }

        @Test
        void testRemoveAllShapes() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);
            ShapeCircle shapeCircle = new ShapeCircle(5);
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);
            collector.addFigure(shapeSquare);
            collector.addFigure(shapeCircle);
            collector.addFigure(shapeTriangle);

            //When
            boolean resultSquare = collector.removeFigure(shapeSquare);
            boolean resultCircle = collector.removeFigure(shapeCircle);
            boolean resultTriangle = collector.removeFigure(shapeTriangle);

            //Then
            Assertions.assertTrue(resultSquare);
            Assertions.assertTrue(resultCircle);
            Assertions.assertTrue(resultTriangle);
            Assertions.assertEquals(0, collector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for getting figures")
    class TestGetFigures {
        @Test
        void testGetSquare() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);
            collector.addFigure(shapeSquare);

            //When
            Shape retrievedSquare;
            retrievedSquare = collector.getFigure(0);

            //Then
            Assertions.assertEquals(shapeSquare, retrievedSquare);
        }

        @Test
        void testGetCircle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeCircle shapeCircle = new ShapeCircle(5);
            collector.addFigure(shapeCircle);

            //When
            Shape retrievedSquare;
            retrievedSquare = collector.getFigure(0);

            //Then
            Assertions.assertEquals(shapeCircle, retrievedSquare);
        }

        @Test
        void testGetTriangle() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);
            collector.addFigure(shapeTriangle);

            //When
            Shape retrievedSquare;
            retrievedSquare = collector.getFigure(0);

            //Then
            Assertions.assertEquals(shapeTriangle, retrievedSquare);
        }
    }

    @Nested
    @DisplayName("Tests for showing figures")
    class TestShowFigures {
        @Test
        void testShowFigures() {
            //Given
            ShapeCollector collector = new ShapeCollector();
            ShapeSquare shapeSquare = new ShapeSquare(5);
            ShapeCircle shapeCircle = new ShapeCircle(5);
            ShapeTriangle shapeTriangle = new ShapeTriangle(5, 5);
            collector.addFigure(shapeSquare);
            collector.addFigure(shapeCircle);
            collector.addFigure(shapeTriangle);

            //When
            String allFigures = collector.showFigures();

            //Then
            Assertions.assertEquals("Square, Circle, Triangle", allFigures);
        }
    }
}
