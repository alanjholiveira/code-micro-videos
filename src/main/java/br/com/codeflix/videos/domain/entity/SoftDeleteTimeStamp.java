package br.com.codeflix.videos.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class SoftDeleteTimeStamp implements Serializable {

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @Column(name = "delete_at")
    private LocalDateTime deleteAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoftDeleteTimeStamp that = (SoftDeleteTimeStamp) o;
        return Objects.equals(createdAt, that.createdAt) && Objects.equals(updateAt, that.updateAt) && Objects.equals(deleteAt, that.deleteAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, updateAt, deleteAt);
    }
}
