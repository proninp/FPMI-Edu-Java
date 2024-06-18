package task1_6_9;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final int LOWER_GRADE = 2;
    private final int UPPER_GRADE = 5;

    @Getter
    private String name;
    private List<Integer> grades;

    public Student(String name, int...grades) {
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade: grades) {
            if (grade < LOWER_GRADE || grade > UPPER_GRADE) {
                throw new IllegalArgumentException(String.format(
                        "Оценка может быть задана в диапазоне от %d до %d включительно.", LOWER_GRADE, UPPER_GRADE));
            }
            this.grades.add(grade);
        }
    }

    /**
     * Список оценок студента
     * @return массив с оценками студента
     */
    public int[] getGrades() {
        return grades.stream().mapToInt(g -> g).toArray();
    }

    /**
     * Средняя оценка студента
     * @return Средняя оценка
     */
    public double avgGrade() {
        double avg = 0.0;
        if (grades == null || grades.isEmpty())
            return avg;
        return grades.stream()
                .mapToDouble(g -> g)
                .average()
                .getAsDouble();
    }

    /**
     * Является ли студен отличником
     * @return Отличник - true, иначе - false
     */
    public boolean isExcellent() {
        if (grades == null || grades.isEmpty())
            return false;
        return grades.stream().allMatch(g -> g == 5);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (grades != null && !grades.isEmpty()) {
            sb.append(": [");
            for (int grade: grades) {
                sb.append(grade).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
        }
        return sb.toString();
    }
}
