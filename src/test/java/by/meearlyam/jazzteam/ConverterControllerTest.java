package by.meearlyam.jazzteam;

import by.meearlyam.jazzteam.model.AbstractNumberToStringConverter;
import by.meearlyam.jazzteam.model.DefaultNumberToStringConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Number to string converter controller test class that provides DDT
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class ConverterControllerTest {

    AbstractNumberToStringConverter processor = new DefaultNumberToStringConverter();

    @Test
    public void testGetName() {

        int zero = 1111111111;
        String ZERO = "один миллиард сто одиннадцать миллионов сто одиннадцать тысяч сто одиннадцать";

        System.out.println("Test Program: test 1 - zero");
        System.out.println(zero + " = " + processor.getName(zero));
        assertEquals("Ошибка, нет нуля", ZERO, processor.getName(zero));
    }

    @Test
    public void testGetNameZero() {

        int zero = 0;
        String ZERO = "ноль";

        System.out.println("Test Program: test 1 - zero");
        System.out.println(zero + " = " + processor.getName(zero));
        assertEquals("Ошибка, нет нуля", ZERO, processor.getName(zero));
    }

    @Test
    public void testGetNameUnit() {

        String[] TOKENS = new String[]{"один", "два", "три", "четыре",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать",
                "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};

        System.out.println("Test Program: test 2 - Numbers 1-19");

        for (int i = 1; i < 20; i++) {
            System.out.println(i + " = " + processor.getName(i));
            assertEquals("Ошибка в числах от 1-ого до 19-и", TOKENS[i - 1], processor.getName(i));
        }
    }

    @Test
    public void testGetNameTens() {

        String[] TOKENS = new String[]{"двадцать один", "сорок два", "девяносто три", "тридцать четыре",
                "пятьдесят пять", "семьдесят шесть", "восемьдесят семь", "шестьдесят девять"};
        int tokens[] = new int[]{21, 42, 93, 34, 55, 76, 87, 69};

        System.out.println("Test Program: test 3 - Numbers > 20");

        //проверка всех чисел в массиве двузначных чисел
        for (int i = 1; i < 8; i++) {
            System.out.println(tokens[i - 1] + " = " + processor.getName(tokens[i - 1]));
            assertEquals(TOKENS[i - 1], processor.getName(tokens[i - 1]));
        }
    }

    @Test
    public void testGetNameAllTable() {

        System.out.println("Test Program: test 3 - Different numbers");
        InputStream in;
        HSSFWorkbook wb;
        try {
            in = new FileInputStream("src/main/resources/TestData.xls");
            wb = new HSSFWorkbook(in);

            long inNumber = 0;
            String inString = null;

            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    CellType cellType = cell.getCellType();

                    switch (cellType) {
                        case NUMERIC:
                            System.out.print((inNumber = (long) cell.getNumericCellValue()) + " = ");
                            break;

                        case STRING:
                            System.out.print((inString = cell.getStringCellValue()));
                            break;

                        default:
                            break;
                    }
                }
                System.out.println();
                assertEquals("Ошибка в числе: " + inNumber, inString, processor.getName(inNumber));
            }
        } catch(FileNotFoundException e) {
            System.out.println("Файл с тестовыми данными не найден!");
        } catch (IOException e) {
            System.out.println("Файл с тестовыми данными не может быть прочитан!");
        }
    }
}
