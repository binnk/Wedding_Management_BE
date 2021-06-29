package home.javaweb.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name = "lobby_category")
	public class LobbyCategoryEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "name")
		private String name;
		@Column(name = "mintable")
		private int mintable;
		@Column(name = "minpricetable")
		private float minPriceTable;
		@JsonIgnore
		@Column(name = "active")
		Boolean active;
		public Boolean getActive() {
			return active;
		}
		public void setActive(Boolean active) {
			this.active = active;
		}
		public  LobbyCategoryEntity id(Long id) {
			this.id = id;
			return this;
		}
		public  LobbyCategoryEntity name(String name) {
			this.name = name;
			return this;
		}
		public  LobbyCategoryEntity mintable(int mintable) {
			this.mintable = mintable;
			return this;
		}
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
		public int getMintable() {
			return mintable;
		}
		public void setMintable(int mintable) {
			this.mintable = mintable;
		}
		public float getMinPriceTable() {
			return minPriceTable;
		}
		public void setMinPriceTable(float minPriceTable) {
			this.minPriceTable = minPriceTable;
		}
	}
