import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Student implements Comparable<Student> {
		String name;
		int korean;
		int english;
		int math;

		public Student(String name, int korean, int english, int math) {
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		@Override
		public int compareTo(Student other) {
			if (other.korean == this.korean) {
				if (other.english == this.english) {
					if (other.math == this.math) {
						return this.name.compareTo(other.name);
					}
					return other.math - this.math;
				}
				return this.english - other.english;
			}

			return other.korean - this.korean;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Student[] students = new Student[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());

			students[i] = new Student(name, korean, english, math);
		}

		Arrays.sort(students);
		for (Student student : students) {
			sb.append(student.name).append('\n');
		}

		System.out.println(sb);
	}
}
