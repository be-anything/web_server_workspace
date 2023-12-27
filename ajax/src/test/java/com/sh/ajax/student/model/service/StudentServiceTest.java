package com.sh.ajax.student.model.service;

import com.sh.ajax.student.model.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 항목
 * - fixture 자체 테스트
 * - 학생이름 검색
 * - "이" 검색시 이민정, 이재준
 * - "진" 고혜진, 오우진, 정진우, 천무진
 * - "한" 한보경, 한승훈, 한준희
 *
 * @ParameterizedTest
 * @ValueSource
 * 사용해볼것!
 */
public class StudentServiceTest {
    // fixture
    private StudentService studentService;

    // @BeforeEach
    @BeforeEach
    public void beforeEach(){
        studentService = new StudentService();
    }

    @DisplayName("StudentService객체는 null이 아니다.")
    public void test1(){
        assertThat(studentService).isNotNull();
    }

    @DisplayName("학생이름을 검색할 수 있습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"이", "진", "한"})
    public void test2(String name){
        // given
        assertThat(name).isNotNull();
        // when
        // then
        List<Student> students = studentService.findByName(name);
        assertThat(students)
                .isNotNull()
                .allSatisfy((student -> {
                    assertThat(student).isNotNull();
                    assertThat(student.getId()).isNotZero().isNotNull();
                    assertThat(student.getName()).isNotNull().contains(name);
                }));
    }
}
