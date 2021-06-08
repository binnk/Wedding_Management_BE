package home.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "lobby")
	public class LobbyEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "name")
		private String name;
		@Column(name = "id_lobbycategory")
		private String id_lobycategory;
		@Column(name = "image")
		private String image;
		@Column(name = "maxtable")
		private int maxtable;
		@Column(name = "min_unitpricetable")
		private Long min_unitpricetable;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId_lobycategory() {
			return id_lobycategory;
		}
		public void setId_lobycategory(String id_lobycategory) {
			this.id_lobycategory = id_lobycategory;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public int getMaxtable() {
			return maxtable;
		}
		public void setMaxtable(int maxtable) {
			this.maxtable = maxtable;
		}
		public Long getMin_unitpricetable() {
			return min_unitpricetable;
		}
		public void setMin_unitpricetable(Long min_unitpricetable) {
			this.min_unitpricetable = min_unitpricetable;
		}
}