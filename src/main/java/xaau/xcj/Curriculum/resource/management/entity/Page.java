package xaau.xcj.Curriculum.resource.management.entity;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:33
 * @message:分页的bean
 */
    public class Page<T> {
        private int tp; // 总页数
        private int ps; // 每页的记录数
        private int ts; // 总记录数
        private int cp; // 当前页
        private int ns; // 从当前位置开始
        private String url; // 路径
        private List<T> list; // 当前页保存的记录

        public int getTp() {
            int tp = ts / ps;
            return ts%ps == 0 ? tp : tp + 1;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getTs() {
            return ts;
        }

        public void setTs(int ts) {
            this.ts = ts;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getNs() {
            return (cp - 1) * ps;
        }

        public void setNs(int ns) {
            this.ns = ns;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

    }

