package com.caglarb.issuemanagement.repo;


import com.caglarb.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

//bu interface aracılığıyla entityler database'e yazılıp okunup ya da daha farklı sorgular yapılması gibi işlemleri yapıyor
public interface IssueRepository extends JpaRepository<Issue, Long> // JPARepository bize hazır methodlar sunar,
// burada hangi tabloya hizmet edecek ve id'sinin tipinin ne olduğunu veriyoruz
{

}
