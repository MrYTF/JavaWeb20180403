package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.util.DataAccess;

public class IHBDao {
		//finCostomerAll
		public Vector<CostomerDto> findCostomer() {
			Vector<CostomerDto> v1=new Vector<CostomerDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("select * from costomer where ���=1");
			rs=prep.executeQuery();
			while(rs.next()) {//��������
				CostomerDto i=new CostomerDto();
				i.setId(rs.getString("�ͻ����"));
				i.setName(rs.getString("�ͻ�����"));
				i.setSex(rs.getString("�ͻ��Ա�"));
				i.setAge(rs.getInt("�ͻ�����"));
				i.setTelephone(rs.getString("��ϵ��ʽ"));
				i.setCourse(rs.getString("ѡ�μ�¼"));
				i.setRegister(rs.getString("ע��Ǽ�"));
				i.setType(rs.getString("�ͻ�����"));
				v1.add(i);
			}
			}catch(SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v1;
		}
		
		//findCourseAll
		public Vector<CourseDto> findCourse() {
			Vector<CourseDto> v=new Vector<CourseDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("select * from course where ���=1");
			rs=prep.executeQuery();
			while(rs.next()) {//��������
				CourseDto i=new CourseDto();
				//course
				i.setCid(rs.getString("�γ̱��"));
				i.setCname(rs.getString("�γ�����"));
				i.setTime(rs.getString("�Ͽ�ʱ��"));
				i.setSite(rs.getString("�Ͽεص�"));
				i.setPrice(rs.getString("�γ̼۸�"));
				i.setLecturer(rs.getString("��ʦ����"));
				i.setCtype(rs.getString("�γ�����"));
				v.add(i);
			}
			}catch(SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v;
		}
		
		//findTeacherAll
		public Vector<TeacherDto> findTeacher() {
			Vector<TeacherDto> v2=new Vector<TeacherDto>();
			Connection conn=null;
			PreparedStatement prep=null;
			ResultSet rs=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("select * from teacher where ���=1");
			rs=prep.executeQuery();
			while(rs.next()) {//��������
				TeacherDto i=new TeacherDto();
				//teacher
				i.setTid(rs.getString("��ʦ���"));
				i.setTname(rs.getString("��ʦ����"));
				i.setTsex(rs.getString("��ʦ�Ա�"));
				i.setTage(rs.getString("��ʦ����"));
				i.setCelphone(rs.getString("��ϵ��ʽ"));
				v2.add(i);
			}
			}catch(SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, rs);
			}
			return v2;
		}
		
		
		//findCostomerById
			public CostomerDto findById(String _id) {
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where �ͻ����=? and ���=1");
				prep.setString(1,_id);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String id=rs.getString("�ͻ����");
					String name=rs.getString("�ͻ�����");
					String sex=rs.getString("�ͻ��Ա�");
					int age=rs.getInt("�ͻ�����");
					String telephone=rs.getString("��ϵ��ʽ");
					String course=rs.getString("ѡ�μ�¼");
					String register=rs.getString("ע��Ǽ�");
					String type=rs.getString("�ͻ�����");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCostomerByName
			public  CostomerDto findByName(String _name) {
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where �ͻ�����=? and ���=1");
				prep.setString(1,_name);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String id=rs.getString("�ͻ����");
					String name=rs.getString("�ͻ�����");
					String sex=rs.getString("�ͻ��Ա�");
					int age=rs.getInt("�ͻ�����");
					String telephone=rs.getString("��ϵ��ʽ");
					String course=rs.getString("ѡ�μ�¼");
					String register=rs.getString("ע��Ǽ�");
					String type=rs.getString("�ͻ�����");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCostomerByClass
			public Vector<CostomerDto> findByCourse(String _course) {
				Vector<CostomerDto> v = new Vector<CostomerDto>();
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where ѡ�μ�¼=? and ���=1");
				prep.setString(1,_course);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String id=rs.getString("�ͻ����");
					String name=rs.getString("�ͻ�����");
					String sex=rs.getString("�ͻ��Ա�");
					int age=rs.getInt("�ͻ�����");
					String telephone=rs.getString("��ϵ��ʽ");
					String course=rs.getString("ѡ�μ�¼");
					String register=rs.getString("ע��Ǽ�");
					String type=rs.getString("�ͻ�����");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					System.out.println(st);
					v.add(st);
					
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return v;
			}
			//findCostomerByType
			public Vector<CostomerDto> findByType(String _type) {
				Vector<CostomerDto> v = new Vector<CostomerDto>();
				CostomerDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from costomer where �ͻ�����=? and ���=1");
				prep.setString(1,_type);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String id=rs.getString("�ͻ����");
					String name=rs.getString("�ͻ�����");
					String sex=rs.getString("�ͻ��Ա�");
					int age=rs.getInt("�ͻ�����");
					String telephone=rs.getString("��ϵ��ʽ");
					String course=rs.getString("ѡ�μ�¼");
					String register=rs.getString("ע��Ǽ�");
					String type=rs.getString("�ͻ�����");
					st=new CostomerDto(id,name,sex,age,telephone,course,register,type);
					System.out.println(st);
					v.add(st);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return v;
			}
			
			//findCourseByCid
			public CourseDto findByCid(String _cid) {
				CourseDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from course where �γ̱��=? and ���=1");
				prep.setString(1,_cid);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String cid=rs.getString("�γ̱��");
					String cname=rs.getString("�γ�����");
					String time=rs.getString("�Ͽ�ʱ��");
					String site=rs.getString("�Ͽεص�");
					String price=rs.getString("�γ̼۸�");
					String lecturer=rs.getString("��ʦ����");
					String ctype=rs.getString("�γ�����");
					st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCourseByCname
			public CourseDto findByCname(String _cname) {
				CourseDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from course where �γ�����=? and ���=1");
				prep.setString(1,_cname);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String cid=rs.getString("�γ̱��");
					String cname=rs.getString("�γ�����");
					String time=rs.getString("�Ͽ�ʱ��");
					String site=rs.getString("�Ͽεص�");
					String price=rs.getString("�γ̼۸�");
					String lecturer=rs.getString("��ʦ����");
					String ctype=rs.getString("�γ�����");
					st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCourseByLecturer
			public CourseDto findByLecturer(String _lecturer) {
				CourseDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from course where ��ʦ����=? and ���=1");
				prep.setString(1,_lecturer);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String cid=rs.getString("�γ̱��");
					String cname=rs.getString("�γ�����");
					String time=rs.getString("�Ͽ�ʱ��");
					String site=rs.getString("�Ͽεص�");
					String price=rs.getString("�γ̼۸�");
					String lecturer=rs.getString("��ʦ����");
					String ctype=rs.getString("�γ�����");
					st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findCourseByCtype
			public CourseDto findByCtype(String _ctype) {
				CourseDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from course where �γ�����=? and ���=1");
				prep.setString(1,_ctype);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String cid=rs.getString("�γ̱��");
					String cname=rs.getString("�γ�����");
					String time=rs.getString("�Ͽ�ʱ��");
					String site=rs.getString("�Ͽεص�");
					String price=rs.getString("�γ̼۸�");
					String lecturer=rs.getString("��ʦ����");
					String ctype=rs.getString("�γ�����");
					st=new CourseDto(cid,cname,time,site,price,lecturer,ctype);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findTeacherByTid
			public TeacherDto findByTid(String _tid) {
				TeacherDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from teacher where ��ʦ���=? and ���=1");
				prep.setString(1,_tid);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String tid=rs.getString("��ʦ���");
					String tname=rs.getString("��ʦ����");
					String tsex=rs.getString("��ʦ�Ա�");
					String tage=rs.getString("��ʦ����");
					String celphone=rs.getString("��ϵ��ʽ");
					st=new TeacherDto(tid,tname,tsex,tage,celphone);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
			//findTeacherByTname
			public TeacherDto findByTname(String _tname) {
				TeacherDto st=null;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs=null;
				try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("select * from teacher where ��ʦ����=? and ���=1");
				prep.setString(1,_tname);
				rs=prep.executeQuery();	
				while(rs.next()) {//��������
					String tid=rs.getString("��ʦ���");
					String tname=rs.getString("��ʦ����");
					String tsex=rs.getString("��ʦ�Ա�");
					String tage=rs.getString("��ʦ����");
					String celphone=rs.getString("��ϵ��ʽ");
					st=new TeacherDto(tid,tname,tsex,tage,celphone);
				}
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, rs);
				}
				return st;
			}
		
			//insertTeacher
			public boolean insertTeacher(String _tid, String _tname, String _tsex, int _tage, String _celphone) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from teacher where ��ʦ��� = ?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _tid);
				rs = prep.executeQuery();
				while(rs.next())
				{
					//�� rs.getInt("���") == 0 ʱ��ʾ_tid��ŵ���ʦ�����ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
					if(rs.getInt("���") == 0) {
						String updatesql = "update teacher set ��� = 1 where ��ʦ��� = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _tid);
						prep.executeUpdate();
						//����֮��ֱ���˳�����������������ִ��
						return true;
					}
					else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
					{
						System.out.println("����ʦ�Ѵ��ڣ������ظ�����");
						return false;
					}
				}
				prep = conn.prepareStatement("insert into teacher values(?,?,?,?,?,?)");
				prep.setString(1, _tid);
				prep.setString(2, _tname);
				prep.setString(3, _tsex);
				prep.setInt(4, _tage);
				prep.setString(5, _celphone);
				prep.setInt(6, 1);
				prep.executeUpdate();
					flag=true;
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
			
			//insertCourse
			public boolean insertCourse(String _cid, String _cname, String _time, String _site, String _price, String _lecturer, String _ctype) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from course where �γ̱��=?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _cid);
				rs = prep.executeQuery();
				while(rs.next())
				{
					//�� rs.getInt("���") == 0 ʱ��ʾ_tid��ŵ���ʦ�����ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
					if(rs.getInt("���") == 0) {
						String updatesql = "update course set ��� = 1 where �γ̱�� = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _cid);
						prep.executeUpdate();
						//����֮��ֱ���˳�����������������ִ��
						return true;
					}
					else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
					{
						System.out.println("�ÿγ��Ѵ��ڣ������ظ�����");
						return false;
					}
				}
				prep=conn.prepareStatement("insert into course values(?,?,?,?,?,?,?,?)");
				prep.setString(1, _cid);
				prep.setString(2, _cname);
				prep.setString(3, _time);
				prep.setString(4, _site);
				prep.setString(5, _price);
				prep.setString(6, _lecturer);
				prep.setString(7, _ctype);
				prep.setInt(8, 1);
				prep.executeUpdate();
				//if(number != null)
					flag=true;
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
			
		//insertCostomer
			public boolean insertCostomer(String _id, String _name, String _sex, int _age, String _telephone, String _course, String _register, String _type) {
				boolean flag=false;
				Connection conn=null;
				PreparedStatement prep=null;
				ResultSet rs = null;
				try {
				conn=DataAccess.getConnection();
				String sql = "select * from costomer where �ͻ����=?";
				prep = conn.prepareStatement(sql);
				prep.setString(1, _id);
				rs = prep.executeQuery();
				
				while(rs.next())
				{
					//�� rs.getInt("���") == 0 ʱ��ʾ_tid��ŵ���ʦ�����ݿ����Ѿ�����ɾ������ʱֱ�Ӹ���isExist�ֶμ���
					if(rs.getInt("���") == 0) {
						String updatesql = "update costomer set ��� = 1 where �ͻ���� = ?";
						prep = conn.prepareStatement(updatesql);
						prep.setString(1, _id);
						prep.executeUpdate();
						//����֮��ֱ���˳�����������������ִ��
						return true;
					}
					else//��ʾ���ݿ��Ѵ���������¼�������ٴβ��룬ֱ�ӽ�������
					{
						System.out.println("�ÿͻ��Ѵ��ڣ������ظ�����");
						return false;
					}
				}
				prep=conn.prepareStatement("insert into costomer values(?,?,?,?,?,?,?,?,?)");
				prep.setString(1, _id);
				prep.setString(2, _name);
				prep.setString(3, _sex);
				prep.setInt(4, _age);
				prep.setString(5, _telephone);
				prep.setString(6, _course);
				prep.setString(7, _register);
				prep.setString(8, _type);
				prep.setInt(9, 1);
				prep.executeUpdate();
				//if(number != null)
					flag=true;
				}catch(SQLException e) {
					System.out.println("����SQL���ʱ���ִ���");
					e.printStackTrace();
				}finally {
					DataAccess.closeconn(conn, null, prep, null);	
				}
				return flag;
			}	
		
		//deleteCostomerById
		public boolean deleteCostomerById(String _id) {
			boolean flag=false;
			Connection conn=null;
			PreparedStatement prep=null;
			try {
			conn=DataAccess.getConnection();
			prep=conn.prepareStatement("update costomer set ���=0 where �ͻ����=?");
			prep.setString(1, _id);
			prep.executeUpdate();
				flag=true;
			}catch(SQLException e) {
				System.out.println("����SQL���ʱ���ִ���");
				e.printStackTrace();
			}finally {
				DataAccess.closeconn(conn, null, prep, null);
			}
			return flag;
		}
		//deleteCostomerByName
				public boolean deleteCostomerByName(String _name) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update costomer set ���=0 where �ͻ�����=?");
					prep.setString(1, _name);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteCourseById
				public boolean deleteCourseById(String _cid) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update course set ���=0 where �γ̱��=?");
					prep.setString(1, _cid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteCourseByCname
				public boolean deleteCourseByCname(String _cname) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update course set ���=0 where �γ�����=?");
					prep.setString(1, _cname);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				
				//deleteTeacherById
				public boolean deleteTeacherById (String _tid) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update teacher set ���=0 where ��ʦ���=?");
					prep.setString(1, _tid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//deleteTeacherByName
				public boolean deleteTeacherByName(String _tname) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					prep=conn.prepareStatement("update teacher set ���=0 where ��ʦ����=?");
					prep.setString(1, _tname);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);
					}
					return flag;
				}
				//updateCostomer
				public boolean updateCostomerById(String _id, String _name,String _sex,int _age,String _telephone,String _course ,String _record,String _type) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update costomer set �ͻ����� = ? ,�ͻ��Ա�=?,�ͻ�����=?,��ϵ��ʽ=?,ѡ�μ�¼=?,ע��Ǽ�=?,�ͻ�����=? where �ͻ���� = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _name);
					prep.setString(2, _sex);
					prep.setInt(3,_age );
					prep.setString(4, _telephone);
					prep.setString(5, _course);
					prep.setString(6, _record);
					prep.setString(7,_type);
					prep.setString(8, _id);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
				
				//updateCourse
				public boolean updateCourseById(String _cid, String _cname, String _time, String _site) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update course set �γ����� = ? , �Ͽ�ʱ��=? , �Ͽεص�=? where �γ̱�� = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _cname);
					prep.setString(2, _site);
					prep.setString(3, _time);
					prep.setString(4, _cid);
					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
				
				//updateTeacher
				public boolean updateTeacherById(String _tid, String _tname,String _tsex,String _tage,String _celphone) {
					boolean flag=false;
					Connection conn=null;
					PreparedStatement prep=null;
					try {
					conn=DataAccess.getConnection();
					String sql = "update teacher set ��ʦ���� = ? ,��ʦ�Ա�=?,��ʦ����=?, ��ϵ��ʽ=? where ��ʦ��� = ?";
					prep=conn.prepareStatement(sql);
					prep.setString(1, _tname);
					prep.setString(2, _tsex);
					prep.setString(3, _tage);
					prep.setString(4, _celphone);
					prep.setString(5, _tid);

					prep.executeUpdate();
						flag=true;
					}catch(SQLException e) {
						System.out.println("����SQL���ʱ���ִ���");
						e.printStackTrace();
					}finally {
						DataAccess.closeconn(conn, null, prep, null);	
					}
					return flag;
				}
	}	
