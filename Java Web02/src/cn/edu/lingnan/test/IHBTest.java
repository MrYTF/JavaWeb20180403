package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;
import cn.edu.lingnan.dto.CourseDto;
import cn.edu.lingnan.dto.CostomerDto;
import cn.edu.lingnan.dto.TeacherDto;
import cn.edu.lingnan.dao.IHBDao;

public class IHBTest {

	public static void main(String[] args) {
		Vector<CourseDto> v=new Vector<CourseDto>();
		Vector<CostomerDto> v1=new Vector<CostomerDto>();
		Vector<TeacherDto> v2=new Vector<TeacherDto>();
		IHBDao s=new IHBDao();
		CourseDto std=null;
		CostomerDto cd=null;
		TeacherDto td=null;
		Scanner put = new Scanner(System.in);
		int choose = -1;
		while(choose != 0)
		{
			System.out.println("	1.������Ϣ");
			System.out.println("	2.��ѯ��Ϣ");
			System.out.println("	3.������Ϣ");
			System.out.println("	4.ɾ����Ϣ");
			System.out.println("	5.������Ϣ");
			System.out.println("	0.�˳�");
			System.out.print("��ѡ��");
			choose = put.nextInt();
			put.nextLine();//����put.nextInt()����Ļس�������Ӱ�����������
			switch(choose)
			{
				//�˳����ܣ�����0ʱ��ֱ������ѭ��
				case 0:
						System.out.println("ϵͳ�ѳɹ��˳���");
						break;
				//��ѯѧ����Ϣ
				case 1:
					int select = -1;
					while(select != 0)
					{
						System.out.println("	1.�����ͻ���");
						System.out.println("	2.�����γ̱�");
						System.out.println("	3.������ʦ��");
						System.out.println("	0.������һ��");
						System.out.print("��ѡ��");
						select = put.nextInt();
						put.nextLine();
						switch(select)
						{
							case 0:
								break;
									
							case 1:
	
								v1=s.findCostomer();
								for(CostomerDto id:v1)
									System.out.println(id.getId()+" "+id.getName()+" "+id.getSex()+" "+id.getAge()+" "+id.getTelephone()+" "+id.getCourse()+" "+id.getRegister()+" "+id.getType());
									break;
									
							case 2:
								v=s.findCourse();
								for(CourseDto id:v)
									System.out.println(id.getCid()+" "+id.getCname()+" "+id.getTime()+" "+id.getSite()+" "+id.getPrice()+" "+id.getLecturer()+" "+id.getCtype());
								break;
							case 3:	
								v2=s.findTeacher();
								for(TeacherDto id:v2)
									System.out.println(id.getTid()+" "+id.getTname()+" "+id.getTsex()+" "+id.getTage()+" "+id.getCelphone());
								break;
							default:
								System.out.println("�����д�������ѡ��!!");
								break;
						}
					}
						break;
				case 2:	
					int select1 = -1;
					while(select1 != 0)
					{
						System.out.println("	1.���ҿͻ���");
						System.out.println("	2.���ҿγ̱�");
						System.out.println("	3.���ҽ�ʦ��");
						System.out.println("	0.������һ��");
						System.out.print("��ѡ��");
						select1 = put.nextInt();
						put.nextLine();
						switch(select1)
						{
							case 0:
								break;
									
							case 1:
								int aa = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
								while(aa != 0)
								{
									System.out.println("	1.���ͻ���Ų�ѯ");
									System.out.println("	2.���ͻ�������ѯ");
									System.out.println("	3.���ͻ����ڰ༶��ѯ");
									System.out.println("	4.���ͻ����Ͳ�ѯ");
									System.out.println("	0.������һ��");
									System.out.print("��ѡ��");
									aa = put.nextInt();
									put.nextLine();
									
									switch(aa)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("��������Ҫ��ѯ�ͻ��ı�ţ�");
												String id = put.nextLine();
												cd=s.findById(id);
												if(cd == null)
												{
													System.out.println("����ʧ�ܣ�û�д˱�ŵĿͻ�");
												}else
												{
												System.out.println("���ҳɹ������ҵĿͻ�����ϢΪ��");
												System.out.println();
												System.out.println(cd.getId()+" "+cd.getName()+" "+cd.getSex()+" "+cd.getAge()+" "+cd.getTelephone()+" "+cd.getCourse()+" "+cd.getRegister()+" "+cd.getType());
												System.out.println();
												}
												break;
												
										case 2: 
												System.out.print("��������Ҫ��ѯ�ͻ���������");
												String name = put.nextLine();
												cd=s.findByName(name);
												if(cd == null)
												{
													System.out.println("����ʧ�ܣ�û�д������Ŀͻ�");
												}else
												{
												System.out.println("���ҳɹ������ҵĿͻ�����ϢΪ��");
												System.out.println();
												System.out.println(cd.getId()+" "+cd.getName()+" "+cd.getSex()+" "+cd.getAge()+" "+cd.getTelephone()+" "+cd.getCourse()+" "+cd.getRegister()+" "+cd.getType());
												System.out.println();
												}
												break;
												
										case 3:
												System.out.print("��������Ҫ��ѯ�༶�ı�ţ�");
												String course = put.nextLine();
												v1=s.findByCourse(course);
												if(v1.isEmpty())
												{
													System.out.println("����ʧ�ܣ�û�д˰༶�Ŀͻ�");
												}else
												{
												System.out.println("���ҳɹ������ҵ�����Ϊ��");
												System.out.println();
												for(CostomerDto c : v1) {
													System.out.println(c);
												}
												
												System.out.println();
												}
												break;
											
										case 4:
											System.out.print("��������Ҫ��ѯ�Ŀͻ����ͣ�");
											String type = put.nextLine();
											v1=s.findByType(type);
											if(v1.isEmpty())
											{
												System.out.println("����ʧ�ܣ�û�д����͵Ŀͻ�");
											}else
											{
											System.out.println("���ҳɹ������ҵĿͻ�����ϢΪ��");
											System.out.println();
											for(CostomerDto c: v1) {
												System.out.println(c);
											}
											System.out.println();
											}
											break;
										default:
												System.out.println("�������������������ȷ��ѯ��ʽ!!");
												System.out.println("\n");
												break;
												
									}
								}
								break;
							case 2:
									int bb = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
									while(bb != 0)
									{
										System.out.println("	1.���γ̱�Ų�ѯ");
										System.out.println("	2.���γ����Ʋ�ѯ");
										System.out.println("	3.���ڿ���ʦ��ѯ");
										System.out.println("	4.���γ����Ͳ�ѯ");
										System.out.println("	0.������һ��");
										System.out.print("��ѡ��");
										bb = put.nextInt();
										put.nextLine();
										
										switch(bb)
										{
											case 0:
												 	break;
												 	
											case 1:
													System.out.print("��������Ҫ��ѯ�Ŀγ̱�ţ�");
													String cid = put.nextLine();
													std=s.findByCid(cid);
													if(std == null)
													{
														System.out.println("����ʧ�ܣ�û�д˱�ŵĿγ�");
													}else
													{
													System.out.println("���ҳɹ������ҵĿγ���ϢΪ��");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
													
											case 2: 
													System.out.print("��������Ҫ��ѯ�Ŀγ����ƣ�");
													String cname = put.nextLine();
													std=s.findByCname(cname);
													if(std == null)
													{
														System.out.println("����ʧ�ܣ�û�д����ƵĿγ�");
													}else
													{
													System.out.println("���ҳɹ������ҵĿγ���ϢΪ��");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
													
											case 3:
													System.out.print("��������Ҫ��ѯ���ڿ���ʦ������");
													String lecturer = put.nextLine();
													std=s.findByLecturer(lecturer);
													if(std == null)
													{
														System.out.println("����ʧ�ܣ�û�д����ƵĿγ�");
													}else
													{
													System.out.println("���ҳɹ������ҵĿγ���ϢΪ��");
													System.out.println();
													System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
													System.out.println();
													}
													break;
											case 4:
												System.out.print("��������Ҫ��ѯ�Ŀγ����ͣ�");
												String ctype = put.nextLine();
												std=s.findByCtype(ctype);
												if(std == null)
												{
													System.out.println("����ʧ�ܣ�û�д����ƵĿγ�");
												}else
												{
												System.out.println("���ҳɹ������ҵĿγ���ϢΪ��");
												System.out.println();
												System.out.println(std.getCid()+" "+std.getCname()+" "+std.getTime()+" "+std.getSite()+" "+std.getPrice()+" "+std.getLecturer()+" "+std.getCtype());
												System.out.println();
												}
												break;
											default:
													System.out.println("�������������������ȷ��ѯ��ʽ!!");
													System.out.println("\n");
													break;
													
										}
									}
									break;
							case 3:
								int cc = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
								while(cc != 0)
								{
									System.out.println("	1.����ʦ��Ų�ѯ");
									System.out.println("	2.����ʦ������ѯ");
									System.out.println("	0.������һ��");
									System.out.print("��ѡ��");
									cc = put.nextInt();
									put.nextLine();
									
									switch(cc)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("��������Ҫ��ѯ�Ľ�ʦ��ţ�");
												String tid = put.nextLine();
												td=s.findByTid(tid);
												if(std == null)
												{
													System.out.println("����ʧ�ܣ�û�д˱�ŵĽ�ʦ");
												}else
												{
												System.out.println("���ҳɹ������ҵĽ�ʦ��ϢΪ��");
												System.out.println();
												System.out.println(td.getTid()+" "+td.getTname()+" "+td.getTsex()+" "+td.getTage()+" "+td.getCelphone());
												System.out.println();
												}
												break;
												
										case 2: 
												System.out.print("��������Ҫ��ѯ�Ľ�ʦ������");
												String tname = put.nextLine();
												td=s.findByTname(tname);
												if(std == null)
												{
													System.out.println("����ʧ�ܣ�û�д������Ľ�ʦ");
												}else
												{
												System.out.println("���ҳɹ������ҵĽ�ʦ��ϢΪ��");
												System.out.println();
												System.out.println(td.getTid()+" "+td.getTname()+" "+td.getTsex()+" "+td.getTage()+" "+td.getCelphone());
												System.out.println();
												}
												break;
													
										default:
												System.out.println("�������������������ȷ��ѯ��ʽ!!");
												System.out.println("\n");
												break;
												
											}
										}
										break;	
									default:
										System.out.println("�����д�������ѡ��!!");
										break;
									}
								}
								break;
							
				case 3:
					int select2 = -1;
					while(select2 != 0)
					{
						System.out.println("	1.����ͻ���");
						System.out.println("	2.����γ̱�");
						System.out.println("	3.�����ʦ��");
						System.out.println("	0.������һ��");
						System.out.print("��ѡ��");
						select2 = put.nextInt();
						put.nextLine();
						switch(select2)
						{
							case 0:
								break;
									
							case 1:
								String id=null,name=null,sex=null,telephone=null,course=null,register=null,type=null;
								int age=0;
										System.out.println("��������Ҫ����ͻ��ı�ţ�");
										id=put.nextLine();
										
										System.out.println("��������Ҫ����ͻ���������");
										name=put.nextLine();
										
										System.out.println("��������Ҫ����ͻ����Ա�");
										sex=put.nextLine();
									
										System.out.println("��������Ҫ����ͻ������䣺");
										age=put.nextInt();
										put.nextLine();
										System.out.println("��������Ҫ����ͻ�����ϵ��ʽ��");
										telephone=put.nextLine();
										
										System.out.println("��������Ҫ����ͻ���ѡ�μ�¼��");
										course=put.nextLine();
										
										System.out.println("��������Ҫ����ͻ���ע���¼��Ϣ��");
										register=put.nextLine();
										
										System.out.println("��������Ҫ����ͻ������ͣ�");
										type=put.nextLine();
										
										boolean insertflag2=false;
										insertflag2=s.insertCostomer(id, name, sex, age, telephone,course,register, type);
										if(insertflag2) {
											
											System.out.println("����ɹ�,���������ݣ�");
											v1=s.findCostomer();
											System.out.println();
											for(CostomerDto sd:v1) 
												System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
										}
										else 
											System.out.println("����ʧ��");
										System.out.println();
										break;
								
							case 2:
								String cid=null,cname=null,time=null,site=null,price=null,lecturer=null,ctype=null;
								
								
										System.out.println("��������Ҫ����γ̵ı�ţ�");
										cid=put.nextLine();
										
										System.out.println("��������Ҫ����γ̵����ƣ�");
										cname=put.nextLine();
										
										System.out.println("��������Ҫ�����Ͽε�ʱ�䣺");
										time=put.nextLine();
										
										System.out.println("��������Ҫ�����Ͽεĵص㣺");
										site=put.nextLine();
									
										System.out.println("��������Ҫ����γ̵ļ۸�");
										price=put.nextLine();
										
										System.out.println("��������Ҫ����γ̵��ڿ���ʦ��");
										lecturer=put.nextLine();
										
										System.out.println("��������Ҫ����γ̵����ͣ�");
										ctype=put.nextLine();
									
										boolean insertflag1 = false;
										insertflag1=s.insertCourse(cid, cname, time, site, price,lecturer,ctype);
										if(insertflag1) {
											System.out.println("����ɹ�,���������ݣ�");
											v=s.findCourse();
											System.out.println();
											for(CourseDto sd:v) 
												System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer());
										}
										else 
											System.out.println("����ʧ��");
										System.out.println();
										break;
							case 3:
								String tid=null,tname=null,tsex=null,celphone=null;
								int tage=0;
										System.out.println("��������Ҫ�����ʦ�ı�ţ�");
										tid=put.nextLine();
										
										System.out.println("��������Ҫ�����ʦ��������");
										tname=put.nextLine();
										
										System.out.println("��������Ҫ�����ʦ���Ա�");
										tsex=put.nextLine();
									
										System.out.println("��������Ҫ�����ʦ�����䣺");
										tage=put.nextInt();
										put.nextLine();
										System.out.println("��������Ҫ�����ʦ����ϵ��ʽ��");
										celphone=put.nextLine();
										
										boolean insertflag=false;
										insertflag=s.insertTeacher(tid, tname, tsex, tage, celphone);
										if(insertflag) {
											System.out.println("����ɹ�,���������ݣ�");
											v2=s.findTeacher();
											System.out.println();
											for(TeacherDto sd:v2) 
												System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
										}
										else 
											System.out.println("����ʧ��");
										System.out.println();
										break;
							default:
								System.out.println("�����������������!!");
								System.out.println("\n");
								break;
						}
					
					}
					break;
				case 4:
					int select3 = -1;
					while(select3 != 0)
					{
						System.out.println("	1.ɾ���ͻ���");
						System.out.println("	2.ɾ���γ̱�");
						System.out.println("	3.ɾ����ʦ��");
						System.out.println("	0.������һ��");
						System.out.print("��ѡ��");
						select3 = put.nextInt();
						put.nextLine();
						switch(select3)
						{
							case 0:
								break;
									
							case 1:
								int dd = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
								while(dd != 0)
								{
									System.out.println("	1.���ͻ����ɾ��");
									System.out.println("	2.���ͻ�����ɾ��");
									System.out.println("	0.������һ��");
									System.out.print("��ѡ��");
									dd = put.nextInt();
									put.nextLine();
									
									switch(dd)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("������Ҫɾ���Ŀͻ���ţ�");
												String id = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteCostomerById(id);
												if(deleteflag) {
													System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
													v1=s.findCostomer();
													System.out.println();
													for(CostomerDto sd:v1) 
														System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
												}
												else 
													System.out.println("ɾ��ʧ��");
												System.out.println();
												break;
										case 2:
											System.out.print("������Ҫɾ���Ŀͻ�������");
											String name = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteCostomerByName(name);
											if(deleteflag1) {
												System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
												v1=s.findCostomer();
												System.out.println();
												for(CostomerDto sd:v1) 
													System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
											}
											else 
												System.out.println("ɾ��ʧ��");
											System.out.println();
											break;
									
									}
								}
								break;
							case 2:
								int ee = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
								while(ee != 0)
								{
									System.out.println("	1.���γ̱��ɾ��");
									System.out.println("	2.���γ�����ɾ��");
									System.out.println("	0.������һ��");
									System.out.print("��ѡ��");
									ee = put.nextInt();
									put.nextLine();
									
									switch(ee)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("������Ҫɾ���Ŀγ̱�ţ�");
												String cid = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteCourseById(cid);
												if(deleteflag) {
													System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
													v=s.findCourse();
													System.out.println();
													for(CourseDto sd:v) 
														System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
												}
												else 
													System.out.println("ɾ��ʧ��");
												System.out.println();
												break;
										case 2:
											System.out.print("������Ҫɾ���Ŀγ����ƣ�");
											String cname = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteCourseByCname(cname);
											if(deleteflag1) {
												System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
												v=s.findCourse();
												System.out.println();
												for(CourseDto sd:v) 
													System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
											}
											else 
												System.out.println("ɾ��ʧ��");
											System.out.println();
											break;
									}
								}
								break;
							case 3:
								int ff = -1;						//һ��������������ȡ�ļ�����Ϣ��������Ϣ���������
								while(ff != 0)
								{
									System.out.println("	1.����ʦ���ɾ��");
									System.out.println("	2.����ʦ����ɾ��");
									System.out.println("	0.������һ��");
									System.out.print("��ѡ��");
									ff = put.nextInt();
									put.nextLine();
									
									switch(ff)
									{
										case 0:
											 	break;
											 	
										case 1:
												System.out.print("������Ҫɾ���Ľ�ʦ��ţ�");
												String tid = put.nextLine();
												boolean deleteflag=false;
												deleteflag =s.deleteTeacherById(tid);
												if(deleteflag) {
													System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
													v2=s.findTeacher();
													System.out.println();
													for(TeacherDto sd:v2) 
														System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
												}
												else 
													System.out.println("ɾ��ʧ��");
												System.out.println();
												break;
										case 2:
											System.out.print("������Ҫɾ���Ľ�ʦ������");
											String tname = put.nextLine();
											boolean deleteflag1=false;
											deleteflag1 =s.deleteTeacherByName(tname);
											if(deleteflag1) {
												System.out.println("ɾ���ɹ�,ɾ��������ݣ�");
												v2=s.findTeacher();
												System.out.println();
												for(TeacherDto sd:v2) 
													System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
											}
											else 
												System.out.println("ɾ��ʧ��");
											System.out.println();
											break;
									}
								}
								break;
					
							}
						}
							break;
				case 5:
					int select4 = -1;
					while(select4 != 0)
					{
						System.out.println("	1.���¿ͻ���");
						System.out.println("	2.���¿γ̱�");
						System.out.println("	3.���½�ʦ��");
						System.out.println("	0.������һ��");
						System.out.print("��ѡ��");
						select4 = put.nextInt();
						put.nextLine();
						switch(select4)
						{
							case 0:
								break;
									
							case 1:
								System.out.print("��������Ҫ���µĿͻ���ţ�");
								String id = put.nextLine();
								System.out.print("��������º�ͻ���������");
								String name = put.nextLine();
								System.out.print("��������º�ͻ����Ա�");
								String sex = put.nextLine();
								System.out.print("��������º�ͻ������䣺");
								int age = put.nextInt();
								System.out.print("��������º�ͻ�����ϵ��ʽ��");
								String telephone = put.nextLine();
								System.out.print("��������º�ͻ���ѡ�μ�¼��");
								String course = put.nextLine();
								System.out.print("��������º�ͻ���ע��Ǽǣ�");
								String record = put.nextLine();
								System.out.print("��������º�ͻ������ͣ�");
								String type = put.nextLine();
								boolean updateflag=false;
								updateflag=s.updateCostomerById(id,name,sex,age,telephone,course,record,type);
								if(updateflag) {
									System.out.println("���³ɹ�,���º�����ݣ�");
									v1=s.findCostomer();
									System.out.println();
									for(CostomerDto sd:v1) 
										System.out.println(sd.getId()+" "+sd.getName()+" "+sd.getSex()+" "+sd.getAge()+" "+sd.getTelephone()+" "+sd.getCourse()+" "+sd.getRegister()+" "+sd.getType());	
								}
								else 
									System.out.println("����ʧ��");	
								break;
							case 2:
								System.out.print("��������Ҫ���µĿγ̱�ţ�");
								String cid = put.nextLine();
								System.out.print("��������º�Ŀγ����ƣ�");
								String cname = put.nextLine();
								System.out.print("��������º�Ŀγ��Ͽ�ʱ�䣺");
								String time = put.nextLine();
								System.out.print("��������º�Ŀγ��Ͽεص㣺");
								String site = put.nextLine();
								boolean updateflag1=false;
								updateflag1=s.updateCourseById(cid,cname,time,site);
								if(updateflag1) {
									System.out.println("���³ɹ�,���º�����ݣ�");
									v=s.findCourse();
									System.out.println();
									for(CourseDto sd:v) 
										System.out.println(sd.getCid()+" "+sd.getCname()+" "+sd.getTime()+" "+sd.getSite()+" "+sd.getPrice()+" "+sd.getLecturer()+" "+sd.getCtype());
								}
								else 
									System.out.println("����ʧ��");	
								break;
							case 3:
								System.out.print("��������Ҫ���µĽ�ʦ��ţ�");
								String tid = put.nextLine();
								System.out.print("��������º�Ľ�ʦ������");
								String tname = put.nextLine();
								System.out.print("��������º�Ľ�ʦ�Ա�");
								String tsex = put.nextLine();
								System.out.print("��������º�Ľ�ʦ���䣺");
								String tage = put.nextLine();
								System.out.print("��������º�Ľ�ʦ����ϵ��ʽ��");
								String celphone = put.nextLine();
								boolean updateflag2=false;
								updateflag2=s.updateTeacherById(tid,tname,tsex,tage,celphone);
								if(updateflag2) {
									System.out.println("���³ɹ�,���º�����ݣ�");
									v2=s.findTeacher();
									System.out.println();
									for(TeacherDto sd:v2) 
										System.out.println(sd.getTid()+" "+sd.getTname()+" "+sd.getTsex()+" "+sd.getTage()+" "+sd.getCelphone());
								}
								else 
									System.out.println("����ʧ��");	
								break;
							}
						}
					break;
				default:
					System.out.println("�����������������!!");
					System.out.println("\n");
					break;
			}
		}
		put.close();
	}
}


				
	
