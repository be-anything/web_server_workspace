package com.sh.ajax.celeb.model.dao;

import com.sh.ajax.celeb.model.entity.Celeb;
import com.sh.ajax.celeb.model.entity.Type;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sh.ajax.celeb.model.entity.Type.SINGER;
import static com.sh.ajax.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class CelebDaoTest {
    CelebDao celebDao;
    SqlSession session;

    @BeforeEach
    public void setUp(){
        // fixture 생성
        celebDao = new CelebDao();
        session = getSqlSession();
    }

    @AfterEach
    public void tearDown(){
        // fixture 해제
        // session rollback 처리
        session.rollback();
        session.close();
    }

    @Test
    void fixtureTest() {
        assertThat(celebDao).isNotNull();
        assertThat(session).isNotNull();
    }

    @DisplayName("Celeb 전체조회")
    @Test
    void test1() {
        List<Celeb> celebs = celebDao.findAll(session);
        assertThat(celebs).isNotNull()
                .allSatisfy((celeb) -> {
                    assertThat(celeb.getId()).isNotNull();
                    assertThat(celeb.getName()).isNotNull();
                    assertThat(celeb.getType()).isNotNull();
                    assertThat(celeb.getProfile()).isNotNull();
                });
    }
    @DisplayName("Celeb 존재하는 한건 조회")
    @ParameterizedTest
    @MethodSource("celebIdProvider")
    void test2(Long id) {
        Celeb celeb = celebDao.findById(session, id);
        assertThat(celeb).isNotNull();
        assertThat(celeb.getId()).isEqualTo(id);
        System.out.println(celeb);
    }
    @DisplayName("Celeb 존재하지 않는 한건 조회")
    @ParameterizedTest
    @ValueSource(longs = {1000000000000000L, 2000000000000000L})
    void test3(long id) {
        Celeb celeb = celebDao.findById(session, id);
        assertThat(celeb).isNull();
    }
    @DisplayName("Celeb 등록")
    @ParameterizedTest
//    @CsvFileSource({"홍길동,honggd.jpg,SINGER", "신사임당,sinsa.jpg,MODEL"})
    void test4() {
        // id는 시퀀스
        String name = "닝닝";
        Type type = SINGER;
        Celeb celeb = new Celeb();
        celeb.setName(name);
        celeb.setType(type);

        int result = celebDao.insertCeleb(session, celeb);
        assertThat(result).isEqualTo(1);

        Celeb celeb2 = celebDao.findById(session, celeb.getId()); // selectKey로 처리된 값
        assertThat(celeb2).isNotNull();
        assertThat(celeb2.getId()).isEqualTo(celeb.getId());
        assertThat(celeb2.getName()).isEqualTo(name);
        assertThat(celeb2.getType()).isEqualTo(type);
    }
    @DisplayName("Celeb 수정")
    @Test
    void test5() {
        Long id = (long) 11;
        Celeb celeb = celebDao.findById(session, id);
        assertThat(celeb).isNotNull();

        String name = "윈터";
        Type type = SINGER;
        String profile = "default.png";
        celeb.setName(name);
        celeb.setType(type);
        celeb.setProfile(profile);

        int result = celebDao.updateCeleb(session, celeb);
        assertThat(result).isGreaterThan(0);

        celeb = celebDao.findById(session, id);
        assertThat(celeb.getId()).isEqualTo(id);
        assertThat(celeb.getName()).isEqualTo(name);
        assertThat(celeb.getType()).isEqualTo(type);
        assertThat(celeb.getProfile()).isEqualTo(profile);
    }
    @DisplayName("Celeb 삭제")
    @Test
    void test6() {
        Long id = (long) 11;
        Celeb celeb = celebDao.findById(session, id);
        assertThat(celeb).isNotNull();

        int result = celebDao.deleteCeleb(session, id);
        assertThat(result).isEqualTo(1);

        Celeb celeb2 = celebDao.findById(session, id);
        assertThat(celeb2).isNull();
    }

    public static Stream<Long> celebIdProvider(){
        CelebDao celebDao = new CelebDao();
        SqlSession session = getSqlSession();
        List<Celeb> celebs = celebDao.findAll(session);
        return celebs.stream()
                .filter((celeb) -> celeb.getId() <= 5)
                .map((celeb) -> celeb.getId()); // Stream<Long>
    }
}
